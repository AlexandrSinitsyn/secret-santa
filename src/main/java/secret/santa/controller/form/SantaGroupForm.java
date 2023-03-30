package secret.santa.controller.form;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import secret.santa.dto.SantaGroup;

import java.util.ArrayList;

public record SantaGroupForm(@NotNull @NotBlank String name,
                             @Nullable  String description) {
    public SantaGroup asGroup() {
        return new SantaGroup(-1, name, description, new ArrayList<>());
    }
}
