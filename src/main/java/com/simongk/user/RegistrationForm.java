package com.simongk.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
@Data
public class RegistrationForm {

    @NotEmpty
    private String name = "";
    @NotEmpty
    private String email = "";
    @NotEmpty
    private String password = "";
    @NotEmpty
    private String passwordRepeated = "";
    @NotEmpty
    private Role role = Role.USER;


}
