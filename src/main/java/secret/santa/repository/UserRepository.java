package secret.santa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import secret.santa.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
