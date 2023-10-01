package co.uninpahu.sight.admin.exception;

import co.uninpahu.sight.admin.dto.ResponseError;
import co.uninpahu.sight.admin.dto.ResponseErrorList;
import co.uninpahu.sight.admin.util.GenericResponseCodes;
import co.uninpahu.sight.admin.util.GenericResponseMessageResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException argumenException,
            HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return responseBuilder(status, GenericResponseCodes.INCONSISTENCIA_DATOS, handleMethodArgumentNotValidToList(status, argumenException));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        return responseBuilder(status, GenericResponseCodes.ERROR_INTERNO_SERVIDOR, handleHttpRequestMethodNotSupportedToList(status, ex));
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
                                                                          HttpHeaders headers,
                                                                          HttpStatus status,
                                                                          WebRequest request) {
        return responseBuilder(status, GenericResponseCodes.ERROR_INTERNO_SERVIDOR, handleServletRequestBindingExceptionToList(status, ex));
    }

    private ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, GenericResponseCodes genericResponseCodes, List<ResponseErrorList> listErrors) {
        return new ResponseEntity<>(
                ResponseError
                        .builder()
                        .messageResponse(
                                buildGenericMessageResponse(httpStatus, genericResponseCodes)
                        )
                        .errors(
                                listErrors
                        )
                        .build(),
                httpStatus
        );
    }

    private List<ResponseErrorList> handleMethodArgumentNotValidToList(HttpStatus httpStatus, MethodArgumentNotValidException argumenException) {
        List<ResponseErrorList> listErrors = new ArrayList<>();
        listErrors.add(
                    ResponseErrorList
                            .builder()
                            .errorCode(String.valueOf(httpStatus.value()))
                            .errorDetails(argumenException.getMessage())
                            .build()
        );
        return listErrors;
    }

    private List<ResponseErrorList> handleHttpRequestMethodNotSupportedToList(HttpStatus httpStatus, HttpRequestMethodNotSupportedException ex) {
        List<ResponseErrorList> listErrors = new ArrayList<>();
        listErrors.add(
                ResponseErrorList
                        .builder()
                        .errorCode(String.valueOf(httpStatus.value()))
                        .errorDetails(ex.getMessage())
                        .build()
        );
        return listErrors;
    }

    private List<ResponseErrorList> handleServletRequestBindingExceptionToList(HttpStatus httpStatus, ServletRequestBindingException ex) {
        List<ResponseErrorList> listErrors = new ArrayList<>();
        listErrors.add(
                ResponseErrorList
                        .builder()
                        .errorCode(String.valueOf(httpStatus.value()))
                        .errorDetails(ex.getMessage())
                        .build()
        );
        return listErrors;
    }

    private GenericResponseMessageResponse buildGenericMessageResponse(HttpStatus status, GenericResponseCodes genericResponseCodes) {
        if (status != null) {
            return GenericResponseMessageResponse
                    .builder()
                    .responseCode(genericResponseCodes.getValue())
                    .responseDetail(genericResponseCodes.getDescription())
                    .build();
        } else {
            return null;
        }
    }


}
