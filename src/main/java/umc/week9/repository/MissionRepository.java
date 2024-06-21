package umc.week9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week9.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
