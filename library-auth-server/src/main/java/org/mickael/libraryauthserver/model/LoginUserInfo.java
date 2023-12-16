package org.mickael.libraryauthserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserInfo {
    private String username;
    private String password;
}
