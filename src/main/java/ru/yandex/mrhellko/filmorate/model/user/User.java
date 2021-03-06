package ru.yandex.mrhellko.filmorate.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.mrhellko.filmorate.model.LongIdEntity;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class User implements LongIdEntity {

    private Long id;

    @Email
    private String email;

    @Pattern(regexp = "\\S+")
    private String login;

    private String name;

    @Past
    private LocalDate birthday;

    private Set<Long> friends;

    public String getName() {
        return (name == null || name.isBlank()) ? login : name;
    }
}
