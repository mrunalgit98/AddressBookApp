package com.example.addressbook.Exception;

import com.example.addressbook.DTO.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto>handleException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String >errorMessage=errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto responseDto=new ResponseDto("Exception while processing Rest request",errorMessage);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }

}
