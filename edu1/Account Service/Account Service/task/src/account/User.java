package account;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String username;

    @Column
    @NotNull(message = "Lastname cannot be null")
    @NotBlank(message = "Lastname cannot be blank")
    private String lastname;


    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email invalid format")
    @Pattern(regexp = ".+@acme.com", message = "Email invalid format")
    private String email;


    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 100, message = "Password length must be 12 chars minimum!")
    private String password;


    public User() {}

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
