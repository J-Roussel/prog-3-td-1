package app.prog.controller.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UpdateAuthorResponse {
    private long id;
    private String name;
    private String particularity;

}


