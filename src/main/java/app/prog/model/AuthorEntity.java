package app.prog.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
@Builder
@Table(name = "author")
@Entity
public class AuthorEntity implements Serializable {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "birth_date")
    private String birthdate;

    @Column(name = "particularity", nullable = false, length = 150)
    private String particularity;

    public boolean hasParticularity(){
        return (particularity != null);
    }



}
