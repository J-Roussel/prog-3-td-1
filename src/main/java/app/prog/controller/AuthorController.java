package app.prog.controller;


import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
