package umc.week9.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.week9.service.MemberService.MemberMissionService;
import umc.week9.web.dto.MemberMissionRequestDTO;
import umc.week9.web.dto.MemberMissionResponseDTO;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/member-missions")
    public ResponseEntity<MemberMissionResponseDTO> updateMissionStatusToChallenging(@RequestBody @Validated MemberMissionRequestDTO requestDTO) {
        MemberMissionResponseDTO responseDTO = memberMissionService.updateMissionStatusToChallenging(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}

