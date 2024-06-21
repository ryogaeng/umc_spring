package umc.week9.validation.annotation;

import jakarta.validation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class) // java에서 제공하는 사용자가 validation을 커스텀 어노테이션을 통해 할 수 있도록 제공하는 어노테이션
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
