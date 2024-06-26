package umc.week9.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewDTO {
        private String title;
        private Float score;
        private String body;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewListDTO {
        private Long storeId;
    }
}
