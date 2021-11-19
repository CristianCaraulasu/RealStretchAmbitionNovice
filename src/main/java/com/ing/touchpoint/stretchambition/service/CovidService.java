package com.ing.touchpoint.stretchambition.service;

import com.ing.touchpoint.stretchambition.domain.CovidRecord;
import com.ing.touchpoint.stretchambition.repository.CovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidService {

    @Autowired
    private CovidRepository covidRespository;

    public CovidService(CovidRepository covidRepository){
        this.covidRespository = covidRepository;
    }

    public Iterable<CovidRecord> list() {
        return covidRespository.findAll();
    }

//    public Iterable<CovidRecord> save(List<CovidRecord> records){
//        return covidRespository.save(records);
//    }

    public CovidRecord save(CovidRecord record){
        return covidRespository.save(record);
    }

}

