package umc.week9.converter;

import umc.week9.domain.enums.mapping.MemberMission;
import umc.week9.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO toMemberMissionResponseDTO(MemberMission memberMission) {
        MemberMissionResponseDTO responseDTO = new MemberMissionResponseDTO();
        responseDTO.setId(memberMission.getId());
        responseDTO.setMemberId(memberMission.getMember().getId());
        responseDTO.setMissionId(memberMission.getMission().getId());
        responseDTO.setStatus(memberMission.getStatus().name());
        return responseDTO;
    }
}
