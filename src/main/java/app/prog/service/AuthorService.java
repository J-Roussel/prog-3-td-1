package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public List<AuthorEntity> getAuthors(){
        return repository.findAll();
    }

}
