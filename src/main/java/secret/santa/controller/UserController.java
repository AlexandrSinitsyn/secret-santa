package secret.santa.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import secret.santa.controller.form.UserForm;
import secret.santa.controller.form.UserFormExtended;
import secret.santa.dto.SantaGroup;
import secret.santa.dto.User;
import secret.santa.exceptions.NotEnoughUsers;
import secret.santa.service.SantaGroupService;
import secret.santa.service.UserService;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SantaGroupService groupService;

    @Operation(description = "adds new member to the group")
    @PostMapping("/group/{id}/participant")
    public long addGroupUser(@PathVariable("id") final long id,
                             @ModelAttribute("userForm") final UserForm form) {
        return userService.saveUser(form).getId();
    }

    @Operation(description = "deletes user by his id")
    @DeleteMapping("/group/{groupId}/participant/{participantId}")
    public void deleteUser(@PathVariable("groupId") final long id,
                           @PathVariable("participantId") final long participantId) {
        userService.deleteById(participantId);
    }

    @Operation(description = "toss recipients to everyone in the group")
    @PostMapping("/group/{id}/toss")
    public List<User> toss(@PathVariable("id") final long id) {
        final SantaGroup group = groupService.getById(id);

        final List<User> users = group.getUsers();
        if (users.size() < 3) {
            throw new NotEnoughUsers();
        }

        for (int i = 0; i < users.size(); i++) {
            users.get(i).setRecipient(users.get((i + 1) % users.size()));
        }

        return users;
    }

    @Operation(description = "get short info about user's recipient")
    @GetMapping("/group/{groupId}/participant/{participantId}/recipient")
    public UserFormExtended getUserInfo(@PathVariable final long groupId,
                                        @PathVariable final long participantId) {
        return userService.getById(participantId).getRecipient().asExtendedForm();
    }
}
