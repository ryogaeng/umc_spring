package umc.week9.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.week9.apiPayload.ApiResponse;
import umc.week9.converter.StoreConverter;
import umc.week9.domain.Review;
import umc.week9.service.MemberService.ReviewService;
import umc.week9.web.dto.ReviewRequestDTO;
import umc.week9.web.dto.ReviewResponseDTO;
import umc.week9.web.dto.StoreResponseDTO;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Validated
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody @Validated ReviewRequestDTO requestDTO) {
        ReviewResponseDTO responseDTO = reviewService.addReview(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }


    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @GetMapping("/members/{memberId}")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getMyReviews(
            @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page) {

        Page<Review> reviews = reviewService.getMyReviews(memberId, page - 1);  // 페이지는 0부터 시작
        StoreResponseDTO.ReviewPreViewListDTO responseDTO = StoreConverter.reviewPreViewListDTO(reviews);

        return ApiResponse.onSuccess(responseDTO);
    }
}

