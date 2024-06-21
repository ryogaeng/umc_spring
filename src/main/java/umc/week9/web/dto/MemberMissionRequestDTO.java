package umc.week9.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberMissionRequestDTO {

    @NotNull
    private Long memberId;

    @NotNull
    private Long missionId;
}

