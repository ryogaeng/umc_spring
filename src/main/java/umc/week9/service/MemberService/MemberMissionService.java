package umc.week9.service.MemberService;

import umc.week9.web.dto.MemberMissionRequestDTO;
import umc.week9.web.dto.MemberMissionResponseDTO;

public interface MemberMissionService {
    MemberMissionResponseDTO updateMissionStatusToChallenging(MemberMissionRequestDTO requestDTO);
}

