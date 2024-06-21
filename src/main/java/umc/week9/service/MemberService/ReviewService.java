package umc.week9.service.MemberService;

import umc.week9.web.dto.ReviewRequestDTO;
import umc.week9.web.dto.ReviewResponseDTO;

public interface ReviewService {
    ReviewResponseDTO addReview(ReviewRequestDTO requestDTO);
}
