package dev.call.appointment.exception;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioCamposInvalidosException.class)
    public ResponseEntity<ErrorMessage> handleCamposUsuarioInvalidosException(UsuarioCamposInvalidosException exception) {
        ErrorMessage threatResponse = new ErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(ConsultaCamposInvalidosException.class)
    public ResponseEntity<ErrorMessage> handleCamposConsultaInvalidosException(ConsultaCamposInvalidosException exception) {
        ErrorMessage threatResponse = new ErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(MedicoInvalidosException.class)
    public ResponseEntity<ErrorMessage> handleMedicoInvalidoException(MedicoInvalidosException exception) {
        ErrorMessage threatResponse = new ErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(PacienteInvalidosException.class)
    public ResponseEntity<ErrorMessage> handlePacienteInvalidoException(PacienteInvalidosException exception) {
        ErrorMessage threatResponse = new ErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception exception) {
        ErrorMessage threatResponse = new ErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatResponse);
    }
}
