package secret.santa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import secret.santa.dto.SantaGroup;

@Repository
public interface SantaGroupRepository extends JpaRepository<SantaGroup, Long> {
    @Transactional
    @Modifying
    @Query("update SantaGroup s set s.name = ?2, s.description = ?3 where s.id = ?1")
    void updateGroup(long id, @NonNull String name, @Nullable String description);
}
