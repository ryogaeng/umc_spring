package umc.week9.service.MemberService;

import org.springframework.data.domain.Page;
import umc.week9.domain.Review;
import umc.week9.web.dto.ReviewRequestDTO;
import umc.week9.web.dto.ReviewResponseDTO;

public interface ReviewService {
    ReviewResponseDTO addReview(ReviewRequestDTO requestDTO);
    Page<Review> getMyReviews(Long memberId, int page);

}
