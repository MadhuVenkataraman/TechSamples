package com.virtusa.workouts.springworkout.transform;

import com.virtusa.workouts.springworkout.dto.ErrorDto;
import com.virtusa.workouts.springworkout.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavingCardFilterTransform {
    @Autowired
    public MessageTransform messageTransform;
    public <T> ResponseDto<T> getPayload() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode("E100");
        errorDto.setErrorMessage("Saving Account is not allowed");
        return messageTransform.getPayload(null, errorDto);
    }
}
