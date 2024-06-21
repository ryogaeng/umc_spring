package umc.week9.converter;

import umc.week9.domain.Review;
import umc.week9.web.dto.ReviewRequestDTO;
import umc.week9.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO requestDTO) {
        return Review.builder()
                .title(requestDTO.getTitle())
                .score(requestDTO.getScore())
                .build();
    }

    public static ReviewResponseDTO toReviewResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .build();
    }
}
