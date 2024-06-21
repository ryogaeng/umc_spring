package umc.week9.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberMissionResponseDTO {
    private Long id;
    private Long memberId;
    private Long missionId;
    private String status;
}

