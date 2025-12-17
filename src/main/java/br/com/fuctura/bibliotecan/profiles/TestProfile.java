package br.com.fuctura.bibliotecan.profiles;

import br.com.fuctura.bibliotecan.services.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestProfile {

    @Autowired
    private DBService dbService;

    @PostConstruct
    public void instanciaDB() {
        this.dbService.instanciaDB();
    }
}