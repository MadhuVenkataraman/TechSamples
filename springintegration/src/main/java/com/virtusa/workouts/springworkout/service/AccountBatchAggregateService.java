package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.dto.ResponseDto;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountBatchAggregateService {
    public <T> ResponseDto<T> getResponse(List<ResponseDto<T>> responseDtoList){
        ResponseDto responseDto = new ResponseDto<>();
        responseDto.setStatus("Success");
        responseDto.setPayload(responseDtoList);
        return responseDto;
    }
}
