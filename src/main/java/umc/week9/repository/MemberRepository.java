package umc.week9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.week9.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
