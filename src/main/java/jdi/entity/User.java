package jdi.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    public static User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String name;
    private String password;
    private String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

}
