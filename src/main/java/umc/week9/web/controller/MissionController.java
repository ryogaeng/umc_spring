package umc.week9.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.week9.apiPayload.ApiResponse;
import umc.week9.converter.MissionConverter;
import umc.week9.service.MemberService.MissionService;
import umc.week9.web.dto.MissionRequestDTO;
import umc.week9.web.dto.MissionResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/add")
    public ResponseEntity<MissionResponseDTO> addMission(@Valid @RequestBody MissionRequestDTO requestDTO) {
        MissionResponseDTO responseDTO = missionService.addMission(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}