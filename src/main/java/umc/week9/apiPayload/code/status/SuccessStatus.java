package umc.week9.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.week9.apiPayload.code.BaseCode;
import umc.week9.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK("200", "성공");

    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return getReason();
    }
}

