package umc.week9.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.week9.converter.MissionConverter;
import umc.week9.domain.Mission;
import umc.week9.domain.Store;
import umc.week9.repository.MissionRepository;
import umc.week9.repository.StoreRepository;
import umc.week9.web.dto.MissionRequestDTO;
import umc.week9.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public MissionResponseDTO addMission(MissionRequestDTO requestDTO) {
        Store store = storeRepository.findById(requestDTO.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission mission = MissionConverter.toMission(requestDTO, store);
        Mission savedMission = missionRepository.save(mission);

        return MissionConverter.toMissionResponseDTO(savedMission);
    }
}