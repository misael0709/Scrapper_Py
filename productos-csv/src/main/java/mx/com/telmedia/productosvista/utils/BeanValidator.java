package mx.com.telmedia.productosvista.utils;

import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sun.jdi.InternalException;

import mx.com.telmedia.productosvista.response.ResponseDTO;
import mx.com.telmedia.productosvista.utils.exception.BusinessException;



public class BeanValidator {
	public static <T> void validate(T object, Class<?>... groups) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> validatorSet = validator.validate(object, groups);

        validatorSet.forEach(cv -> {
            throw new ConstraintViolationException(validatorSet);
        });
    }


    public static ResponseEntity<ResponseDTO> validaException(Object o, String uid) {

        ResponseEntity<ResponseDTO> response = null;
        ResponseDTO respuestaDTO = new ResponseDTO();

        if(o instanceof BusinessException) {
            //BusinessException e = (BusinessException) o;
            //respuestaDTO.setHeaderResponse(new HeaderResponse( e.getMensaje(), false, null , 0));
            response = new ResponseEntity<>(respuestaDTO, HttpStatus.CONFLICT);
        }


        else if(o instanceof ConstraintViolationException) {
            //ConstraintViolationException e = (ConstraintViolationException) o;
            //respuestaDTO.setHeaderResponse(new HeaderResponse(e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(" | ")), false, null , 0));
            response = new ResponseEntity<>(respuestaDTO, HttpStatus.BAD_REQUEST);
        }else if (o instanceof InternalException) {
            //Exception e = (Exception) o;
            //respuestaDTO.setHeaderResponse(new HeaderResponse(e.getMessage(), false,  uid, 0));
            response = new ResponseEntity<>(respuestaDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }else if (o instanceof InternalError) {
            //Exception e = (Exception) o;
            //respuestaDTO.setHeaderResponse(new HeaderResponse(e.getMessage(), false,  uid, 0));
            response = new ResponseEntity<>(respuestaDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

       else if (o instanceof Exception) {
            //Exception e = (Exception) o;
            //respuestaDTO.setHeaderResponse(new HeaderResponse(e.getMessage(), false,  uid, 0));
            response = new ResponseEntity<>(respuestaDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}
