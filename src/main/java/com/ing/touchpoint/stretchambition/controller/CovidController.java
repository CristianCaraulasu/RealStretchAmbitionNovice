package com.ing.touchpoint.stretchambition.controller;


import com.ing.touchpoint.stretchambition.domain.CovidRecord;
import com.ing.touchpoint.stretchambition.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;



//TODO -> pay attention to list GET method to be a @RestController
@Controller
public class CovidController {

    @Value("${url.covidJsonData}")
    private String url;

    @Autowired
    private CovidService covidService;

    public CovidController(CovidService covidService){
        this.covidService = covidService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<CovidRecord> list()  {
        return covidService.list();
    }

    @PostMapping
    @RequestMapping(value = "/download")
    public String getDataInJsonFormat() {

        try {
            URL url = new URL(this.url);
            InputStream content = url.openStream();

            String jsonData = new String(content.readAllBytes());
            System.out.println("\nAccessed  " + url);

            List<String> results = Arrays.asList(jsonData.split("\n"));
            CovidRecord covidRecord = new CovidRecord();

            results.forEach( result -> {

                // I don't need other data in order to create object of CovidRecord
                if(!(result.contains("dateRep") || result.contains("countriesAndTerritories") || result.contains("cases") || result.contains("deaths") || result.contains("popData202") || result.contains("continentExp"))) {
                        return;
                }
                String value = Arrays.asList(result.split("\"")).get(1);

                switch(value){
                    case "dateRep":
                        List<String> dates = Arrays.asList(result.split("/"));
                        int day = Integer.parseInt(dates.get(0).substring(dates.get(0).length()-2,dates.get(0).length()));
                        int month = Integer.parseInt(dates.get(1));
                        int year = Integer.parseInt(dates.get(2).substring(0,4));
                        LocalDate date = LocalDate.of(year,month,day);
                        covidRecord.setDate(date);
                        break;
                    case "cases":
                        List<String> cases = Arrays.asList(result.split(":"));
                        int numberOfCases = Integer.parseInt(Arrays.asList(cases.get(1).replaceAll(" ","").split(",")).get(0));
                        covidRecord.setCases(numberOfCases);
                        break;
                    case "deaths":
                        List<String> deaths = Arrays.asList(result.split(":"));
                        int numberOfDeaths = Integer.parseInt(Arrays.asList(deaths.get(1).replaceAll(" ","").split(",")).get(0));
                        covidRecord.setDeaths(numberOfDeaths);
                        break;
                    case "countriesAndTerritories":
                        List<String> countriesAndTerritories = Arrays.asList(result.split("\""));
                        covidRecord.setCountry(countriesAndTerritories.get(3));
                        break;
                    case "popData2020":
                        List<String> popData2020 = Arrays.asList(result.split("\""));
                        covidRecord.setPopulation(Integer.parseInt(popData2020.get(3)));
                        break;
                    default:
                        covidService.save(covidRecord);
                        break;
                }

            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        System.out.println("Finished to add data to database");
        return "index.html";
    }

    public int printConsoleText(int counter){
        switch (counter){
            case 1:
                System.out.print("...");
                counter+=10;
                break;
            case 11:
                System.out.print(".......");
                counter+=10;
                break;
            case 21:
                System.out.print("..........");
            default:
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                counter=1;
        }
        return counter;
    }

}
