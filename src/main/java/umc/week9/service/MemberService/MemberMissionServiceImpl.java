package umc.week9.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.week9.converter.MemberMissionConverter;
import umc.week9.domain.Member;
import umc.week9.domain.Mission;
import umc.week9.domain.enums.MissionStatus;
import umc.week9.domain.enums.mapping.MemberMission;
import umc.week9.repository.MemberMissionRepository;
import umc.week9.repository.MemberRepository;
import umc.week9.repository.MissionRepository;
import umc.week9.web.dto.MemberMissionRequestDTO;
import umc.week9.web.dto.MemberMissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMissionResponseDTO updateMissionStatusToChallenging(MemberMissionRequestDTO requestDTO) {
        Member member = memberRepository.findById(requestDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Mission mission = missionRepository.findById(requestDTO.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        MemberMission memberMission = memberMissionRepository.findByMemberAndMission(member, mission)
                .orElse(MemberMission.create(member, mission, MissionStatus.CHALLENGING));

        memberMission.setStatus(MissionStatus.CHALLENGING);

        MemberMission savedMemberMission = memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toMemberMissionResponseDTO(savedMemberMission);
    }
}

