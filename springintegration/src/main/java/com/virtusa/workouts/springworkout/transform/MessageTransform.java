package com.virtusa.workouts.springworkout.transform;

import com.virtusa.workouts.springworkout.dto.ErrorDto;
import com.virtusa.workouts.springworkout.dto.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MessageTransform {

    public <T> ResponseDto<T> getPayload(T object, ErrorDto errorDto){
        ResponseDto<T> payload = new ResponseDto<>();
        if(errorDto ==null){
            //Assumption it is success message
            payload.setPayload(object);
            payload.setStatus("Success");
            payload.setMessage("Completed message key");
        }else{
            payload.getErrorDtoList().add(errorDto);
            payload.setStatus("Failed");
            payload.setMessage("Failed message key");
        }

        return payload;
    }
}
