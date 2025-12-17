package br.com.fuctura.bibliotecan.services;

import br.com.fuctura.bibliotecan.exceptions.ObjectNotFoundException;
import br.com.fuctura.bibliotecan.models.Categoria;
import br.com.fuctura.bibliotecan.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada com o ID: " + id));
    }

    public List<Categoria> findAll() {
        List<Categoria> list = categoriaRepository.findAll();
        if (list.isEmpty()) {
            throw new ObjectNotFoundException("Nenhuma categoria encontrada.");
        }
        return list;
    }

    public Categoria save(Categoria categoria) {
        buscarPorNome(categoria);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        buscarPorNome(categoria);
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {

        Categoria categoria = findById(id);
        if(!categoria.getLivros().isEmpty()){
          throw new DataIntegrityViolationException ("Categoria não pode ser deletada! Possui livros associados.");
        }
        categoriaRepository.deleteById(id);
    }

    private void buscarPorNome(Categoria categoria) {
        Optional<Categoria> cat = categoriaRepository.findByNomeIgnoreCaseContaining(categoria.getNome());
        if (cat.isPresent()) {
            if (!Objects.equals(cat.get().getId(), categoria.getId())) {
                throw new IllegalArgumentException("Categoria já existente com o nome: " + categoria.getNome());
            }
        }
    }
}