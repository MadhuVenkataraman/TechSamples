package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.dto.ResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountReleaseStrategy {
    public boolean canDisplayResult(List<ResponseDto> responseDtoList){
        return  true;
    }
}
