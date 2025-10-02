package dev.call.appointment.repository;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConsultaUsuariosValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConsultaUsuariosValidos {

    String message() default "IDs de médico ou paciente inválidos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
