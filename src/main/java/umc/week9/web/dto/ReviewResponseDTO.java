package umc.week9.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long id;
    private String title;
    private Float score;
    private Long memberId;
    private Long storeId;
}

