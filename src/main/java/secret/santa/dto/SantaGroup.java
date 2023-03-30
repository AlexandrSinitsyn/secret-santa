package secret.santa.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import secret.santa.controller.form.SantaGroupForm;
import secret.santa.controller.form.SantaGroupFormExtended;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "groups")
public class SantaGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    @OneToMany(mappedBy = "id")
    private List<User> users;

    public SantaGroupForm asForm() {
        return new SantaGroupForm(name, description);
    }

    public SantaGroupFormExtended asExtendedForm() {
        return new SantaGroupFormExtended(id, name, description);
    }
}
