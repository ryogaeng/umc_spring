package umc.week9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week9.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
