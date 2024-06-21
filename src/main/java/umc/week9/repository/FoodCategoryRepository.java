package umc.week9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week9.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
