package umc.week9.converter;

import umc.week9.domain.FoodCategory;
import umc.week9.domain.enums.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory -> MemberPrefer.builder()
                        .foodCategory(foodCategory)
                        .build())
                .collect(Collectors.toList());
    }
}
