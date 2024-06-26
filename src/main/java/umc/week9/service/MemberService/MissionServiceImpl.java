package umc.week9.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.week9.converter.MissionConverter;
import umc.week9.domain.Member;
import umc.week9.domain.Mission;
import umc.week9.domain.Store;
import umc.week9.domain.enums.MissionStatus;
import umc.week9.repository.MemberRepository;
import umc.week9.repository.MissionRepository;
import umc.week9.repository.StoreRepository;
import umc.week9.web.dto.MissionRequestDTO;
import umc.week9.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
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

    @Override
    public Page<Mission> getMissionList(Long storeId, int page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));
        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getChallengingMissions(Long memberId, int page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        return missionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
    }
}