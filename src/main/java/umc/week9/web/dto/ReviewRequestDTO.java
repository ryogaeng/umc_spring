package umc.week9.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ReviewRequestDTO {

    @NotNull
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters.")
    private String title;

    @NotNull
    private Float score;

    @NotNull
    private Long memberId;

    @NotNull
    private Long storeId;
}

