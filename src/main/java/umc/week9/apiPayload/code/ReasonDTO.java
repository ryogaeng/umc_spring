package umc.week9.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ReasonDTO {
    private String message;
    private String code;
    private boolean isSuccess;
    private HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

