package umc.week9.converter;

import org.springframework.data.domain.Page;
import umc.week9.domain.Mission;
import umc.week9.domain.Store;
import umc.week9.web.dto.MissionRequestDTO;
import umc.week9.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO requestDTO, Store store) {
        return Mission.builder()
                .reward(requestDTO.getReward())
                .deadline(requestDTO.getDeadline())
                .missionSpec(requestDTO.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .storeId(mission.getStore().getId())
                .build();
    }

    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return MissionResponseDTO.MissionDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(MissionConverter::toMissionDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }

    public static MissionResponseDTO.MissionListDTO missionListDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.MissionDTO> missionDTOList = missionPage.stream()
                .map(mission -> MissionResponseDTO.MissionDTO.builder()
                        .missionId(mission.getId())
                        .reward(mission.getReward())
                        .deadline(mission.getDeadline())
                        .missionSpec(mission.getMissionSpec())
                        .build())
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .build();
    }
}
