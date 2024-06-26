package umc.week9.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.week9.domain.Member;
import umc.week9.domain.Mission;
import umc.week9.domain.Store;
import umc.week9.domain.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
    Page<Mission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);


}
