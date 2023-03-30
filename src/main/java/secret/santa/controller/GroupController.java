package secret.santa.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import secret.santa.controller.form.SantaGroupForm;
import secret.santa.controller.form.SantaGroupFormExtended;
import secret.santa.dto.SantaGroup;
import secret.santa.service.SantaGroupService;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final SantaGroupService santaGroupService;

    @Operation(description = "adds new group by group form {name: string, description: string}")
    @PostMapping("/group")
    public long newGroup(@ModelAttribute("santaForm") final SantaGroupForm form) {
        return santaGroupService.saveGroup(form).getId();
    }

    @Operation(description = "returns all groups whithout userinfo")
    @GetMapping("/groups")
    public List<SantaGroupFormExtended> getAllGroups() {
        return santaGroupService.getAll().stream().map(SantaGroup::asExtendedForm).toList();
    }

    @Operation(description = "returns full info about group, where users' info does not contain recipient")
    @GetMapping("/group/{id}")
    public SantaGroup getGroupInfo(@PathVariable("id") final long id) {
        return santaGroupService.getById(id);
    }

    @Operation(description = "updates the group's description")
    @PutMapping("/group/{id}")
    public void updateGroup(@PathVariable("id") final long id,
                            @ModelAttribute("santaForm") final SantaGroupForm form) {
        santaGroupService.updateGroup(id, form);
    }

    @Operation(description = "deletes the group")
    @DeleteMapping("/group/{id}")
    public void deleteGroup(@PathVariable("id") final long id) {
        santaGroupService.deleteById(id);
    }
}
