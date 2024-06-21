package umc.week9.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.week9.service.MemberService.ReviewService;
import umc.week9.web.dto.ReviewRequestDTO;
import umc.week9.web.dto.ReviewResponseDTO;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Validated
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody @Validated ReviewRequestDTO requestDTO) {
        ReviewResponseDTO responseDTO = reviewService.addReview(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}

