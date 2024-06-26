package umc.week9.service.MemberService;

import org.springframework.data.domain.Page;
import umc.week9.domain.Mission;
import umc.week9.web.dto.MissionRequestDTO;
import umc.week9.web.dto.MissionResponseDTO;

public interface MissionService {
    MissionResponseDTO addMission(MissionRequestDTO requestDTO);
    Page<Mission> getMissionList(Long storeId, int page);
    Page<Mission> getChallengingMissions(Long memberId, int page);


}