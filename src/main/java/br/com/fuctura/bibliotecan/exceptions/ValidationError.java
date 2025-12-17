package br.com.fuctura.bibliotecan.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String field, String defaultMessage) {
        this.errors.add(new FieldMessage(field, defaultMessage));
    }
}
