package umc.week9.domain.enums.mapping;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import umc.week9.domain.Member;
import umc.week9.domain.Mission;
import umc.week9.domain.common.BaseEntity;
import umc.week9.domain.enums.MissionStatus;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public static MemberMission create(Member member, Mission mission, MissionStatus status) {
        MemberMission memberMission = new MemberMission();
        memberMission.member = member;
        memberMission.mission = mission;
        memberMission.status = status;
        return memberMission;
    }
}

