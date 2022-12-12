package app.prog.controller.mapper;

import app.prog.controller.response.AuthorResponse;
import app.prog.model.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorRestMapper {

    public AuthorResponse toRest(AuthorEntity domain){
        return AuthorResponse.builder()
                .id((int) domain.getId())
                .name(domain.getName())
                .particularity(domain.getParticularity())
                .hasParticularity(domain.hasParticularity())
                .build();
    }

}
