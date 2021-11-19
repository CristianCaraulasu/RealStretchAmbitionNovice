package com.ing.touchpoint.stretchambition;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.touchpoint.stretchambition.domain.CovidRecord;
import com.ing.touchpoint.stretchambition.service.CovidService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@SpringBootApplication
public class StretchAmbitionApplication {

    public static void main(String[] args) {

        SpringApplication.run(StretchAmbitionApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(CovidService covidService) {
//        return args -> {
//            //read json and write to DB
//
//            ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<CovidRecord>> typeReference = new TypeReference<List<CovidRecord>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/covid_json_data_tst.txt");
//			try {
//				List<CovidRecord> covidRecords = mapper.readValue(inputStream,typeReference);
//				covidRecords.forEach(covidRecord -> {
//					covidService.save(covidRecord);
//				});
//				System.out.println("CovidRecords Saved");
//			}
//			catch(IOException e){
//				System.out.println("Unable to save covid data: " + e.getMessage());
//			}
//        };
//    }

}
