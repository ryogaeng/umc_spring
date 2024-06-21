package umc.week9.service.MemberService;

import umc.week9.web.dto.MissionRequestDTO;
import umc.week9.web.dto.MissionResponseDTO;

public interface MissionService {
    MissionResponseDTO addMission(MissionRequestDTO requestDTO);
}