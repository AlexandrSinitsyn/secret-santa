package secret.santa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import secret.santa.controller.form.SantaGroupForm;
import secret.santa.dto.SantaGroup;
import secret.santa.repository.SantaGroupRepository;
import secret.santa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SantaGroupService {
    private final SantaGroupRepository santaGroupRepository;

    public SantaGroup saveGroup(final SantaGroupForm form) {
        return santaGroupRepository.save(form.asGroup());
    }

    public List<SantaGroup> getAll() {
        return santaGroupRepository.findAll();
    }

    public SantaGroup getById(final long id) {
        return santaGroupRepository.findById(id).orElse(null);
    }

    public void updateGroup(final long id, final SantaGroupForm form) {
        santaGroupRepository.updateGroup(id, form.name(), form.description());
    }

    public void deleteById(final long id) {
        santaGroupRepository.deleteById(id);
    }
}
