package umc.week9.apiPayload.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import umc.week9.apiPayload.ApiResponse;
import umc.week9.apiPayload.code.ErrorReasonDTO;
import umc.week9.apiPayload.code.status.ErrorStatus;

import javax.validation.ConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e, WebRequest request) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .findFirst()
                .orElse("Constraint violation");

        return handleExceptionInternalConstraint(e, ErrorStatus.valueOf(errorMessage), HttpHeaders.EMPTY, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new LinkedHashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String fieldName = fieldError.getField();
            String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
            errors.merge(fieldName, errorMessage, (existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
        });

        return handleExceptionInternalArgs(e, HttpHeaders.EMPTY, ErrorStatus._BAD_REQUEST, request, errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception e, WebRequest request) {
        e.printStackTrace();
        return handleExceptionInternalFalse(e, ErrorStatus._INTERNAL_SERVER_ERROR, HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR, request, e.getMessage());
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleGeneralException(GeneralException generalException, HttpServletRequest request) {
        ErrorReasonDTO errorReasonHttpStatus = generalException.getErrorReasonHttpStatus();
        return handleExceptionInternal(generalException, errorReasonHttpStatus, null, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, ErrorReasonDTO reason, HttpHeaders headers, HttpServletRequest request) {
        ApiResponse<Object> body = ApiResponse.onFailure(reason.getCode(), reason.getMessage(), null);
        WebRequest webRequest = new ServletWebRequest(request);
        return super.handleExceptionInternal(e, body, headers, reason.getHttpStatus(), webRequest);
    }

    private ResponseEntity<Object> handleExceptionInternalFalse(Exception e, ErrorStatus errorCommonStatus, HttpHeaders headers, HttpStatus status, WebRequest request, String errorPoint) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(), errorCommonStatus.getMessage(), errorPoint);
        return super.handleExceptionInternal(e, body, headers, status, request);
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(Exception e, HttpHeaders headers, ErrorStatus errorCommonStatus, WebRequest request, Map<String, String> errorArgs) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(), errorCommonStatus.getMessage(), errorArgs);
        return super.handleExceptionInternal(e, body, headers, errorCommonStatus.getHttpStatus(), request);
    }

    private ResponseEntity<Object> handleExceptionInternalConstraint(Exception e, ErrorStatus errorCommonStatus, HttpHeaders headers, WebRequest request) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(), errorCommonStatus.getMessage(), null);
        return super.handleExceptionInternal(e, body, headers, errorCommonStatus.getHttpStatus(), request);
    }
}
