package umc.week9.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class MissionResponseDTO {
    private Long id;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
    private Long storeId;

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionListDTO {
        private List<MissionDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionDTO {
        private Long missionId;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
    }
}

