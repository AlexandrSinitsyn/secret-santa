package secret.santa.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import secret.santa.controller.form.UserFormExtended;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity()
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String wish;

    @OneToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;

    public UserFormExtended asExtendedForm() {
        return new UserFormExtended(id, name, wish);
    }
}
