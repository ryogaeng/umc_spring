package umc.week9.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MissionRequestDTO {
    @NotNull
    private Integer reward;

    @NotNull
    private LocalDate deadline;

    @NotNull
    private String missionSpec;

    @NotNull
    private Long storeId;
}
