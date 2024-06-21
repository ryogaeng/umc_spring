package umc.week9.apiPayload.exception.handler;

import lombok.Getter;
import umc.week9.apiPayload.code.status.ErrorStatus;

@Getter
public class FoodCategoryHandler extends RuntimeException {
    private final ErrorStatus errorStatus;

    public FoodCategoryHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}


