package com.virtusa.workouts.springworkout.transform;

import com.virtusa.workouts.springworkout.dto.ErrorDto;
import com.virtusa.workouts.springworkout.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditCardErrorMsgTransform {
    @Autowired
    public MessageTransform messageTransform;
    public <T> ResponseDto<T> getPayload() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode("E200");
        errorDto.setErrorMessage("Credit Account is not allowed");
        return messageTransform.getPayload(null, errorDto);
    }
}
