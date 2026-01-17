package pl.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDate;

public record UpdateUserDto(

        @JsonAlias({ "name", "first_name", "firstName" })
        String firstName,

        String lastName,
        String email,
        LocalDate birthdate
) {}
