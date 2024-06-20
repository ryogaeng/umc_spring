package umc.week9.service.MemberService;

import umc.week9.domain.Member;
import umc.week9.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
