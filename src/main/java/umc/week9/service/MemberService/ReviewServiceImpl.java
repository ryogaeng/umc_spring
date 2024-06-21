package umc.week9.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.week9.converter.ReviewConverter;
import umc.week9.domain.Member;
import umc.week9.domain.Review;
import umc.week9.domain.Store;
import umc.week9.repository.MemberRepository;
import umc.week9.repository.ReviewRepository;
import umc.week9.repository.StoreRepository;
import umc.week9.web.dto.ReviewRequestDTO;
import umc.week9.web.dto.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public ReviewResponseDTO addReview(ReviewRequestDTO requestDTO) {
        Member member = memberRepository.findById(requestDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Store store = storeRepository.findById(requestDTO.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Review review = ReviewConverter.toReview(requestDTO);
        review.setMember(member);
        review.setStore(store);

        Review savedReview = reviewRepository.save(review);

        return ReviewConverter.toReviewResponseDTO(savedReview);
    }
}

