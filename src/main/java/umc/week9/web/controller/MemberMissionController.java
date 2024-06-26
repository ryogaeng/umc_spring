package umc.week9.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.week9.apiPayload.ApiResponse;
import umc.week9.converter.MissionConverter;
import umc.week9.service.MemberService.MemberMissionService;
import umc.week9.service.MemberService.MissionService;
import umc.week9.web.dto.MemberMissionRequestDTO;
import umc.week9.web.dto.MemberMissionResponseDTO;
import umc.week9.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;
    private final MissionService missionService;

    @PostMapping("/member-missions")
    public ResponseEntity<MemberMissionResponseDTO> updateMissionStatusToChallenging(@RequestBody @Validated MemberMissionRequestDTO requestDTO) {
        MemberMissionResponseDTO responseDTO = memberMissionService.updateMissionStatusToChallenging(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "유저가 진행 중인 미션 목록 조회 API", description = "멤버의 진행 중인 미션 목록을 조회하는 API입니다. 페이지 번호를 query string으로 전달하세요.")
    @GetMapping("/members/{memberId}/challenging")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getChallengingMissions(
            @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page) {
        return ApiResponse.onSuccess(MissionConverter.toMissionListDTO(missionService.getChallengingMissions(memberId, page - 1)));
    }
}

