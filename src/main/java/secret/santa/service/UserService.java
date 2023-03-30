package secret.santa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import secret.santa.controller.form.UserForm;
import secret.santa.dto.User;
import secret.santa.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(final UserForm form) {
        return userRepository.save(form.asUser());
    }

    public void deleteById(final long id) {
        userRepository.deleteById(id);
    }

    public User getById(final long id) {
        return userRepository.findById(id).orElse(null);
    }
}
