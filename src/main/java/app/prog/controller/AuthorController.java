package app.prog.controller;


import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {

    private final AuthorService service;
    private final AuthorRestMapper mapper;

    // get all authors
    @GetMapping("/authors")
    public List<AuthorResponse> getAuthors(){
        return service.getAuthors()
                .stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/authors")
    public List<AuthorResponse> createAuthors(@RequestBody List<CreateAuthorResponse> toCreate){
        List<AuthorEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();

        return service.createAuthors(domain)
                .stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/authors")
    public List<AuthorResponse> updateAuthors(@RequestBody List<UpdateAuthorResponse> toUpdate){
        List<AuthorEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();

        return service.updateAuthors(domain)
                .stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/author/{id}")
    public AuthorResponse deleteAuthor(@PathVariable Integer authorId){
        return mapper.toRest(service.deleteAuthor(authorId));
    }
}
