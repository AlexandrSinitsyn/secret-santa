package secret.santa.controller.form;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import secret.santa.dto.User;

public record UserForm(@NotNull @NotBlank String name,
                       @Nullable  String wish) {
    public User asUser() {
        return new User(-1, name, wish, null);
    }
}
