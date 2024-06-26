package umc.week9.service.MemberService;

import org.springframework.data.domain.Page;
import umc.week9.domain.Review;
import umc.week9.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
