package com.virtusa.workouts.springworkout.transform;

import com.virtusa.workouts.springworkout.dto.ErrorDto;
import com.virtusa.workouts.springworkout.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuccessMessageTransform  {
    @Autowired
    public MessageTransform  messageTransform;


    public <T> ResponseDto<T> getPayload(T object) {
        return messageTransform.getPayload(object,null);
    }
}
