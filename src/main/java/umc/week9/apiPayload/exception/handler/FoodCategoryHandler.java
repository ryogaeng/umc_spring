package umc.week9.apiPayload.exception.handler;

public class FoodCategoryHandler extends RuntimeException {
    public FoodCategoryHandler(String message) {
        super(message);
    }
}