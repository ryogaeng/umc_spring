package umc.week9.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class StoreResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReviewResultDTO {
        private Long reviewId;
        private LocalDate createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        private String ownerNickname;
        private Float score;
        private String body;
        private LocalDate createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        private List<ReviewPreViewDTO> reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
