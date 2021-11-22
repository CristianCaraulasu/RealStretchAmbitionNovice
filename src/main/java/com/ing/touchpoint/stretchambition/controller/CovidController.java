package com.ing.touchpoint.stretchambition.controller;


import com.ing.touchpoint.stretchambition.domain.CovidRecord;
import com.ing.touchpoint.stretchambition.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String getDataInJsonFormat() {
        // Make a URL to the web page
        try {

            URL url = new URL(this.url);
            InputStream content = url.openStream();
//            FileWriter myWriter = new FileWriter("covid_json_data.txt");

            String jsonData = new String(content.readAllBytes());
            System.out.println("\n Accessed  " + url);

            List<String> results = Arrays.asList(jsonData.split("\n"));
            results.forEach( result -> {

                if(!(result.contains("dateRep") || result.contains("countriesAndTerritories") || result.contains("cases") || result.contains("deaths") || result.contains("popData202"))) {

                }
                String value = Arrays.asList(result.split("\"")).get(1);
                switch(value){
                    case "dateRep":
                        CovidRecord covidRecord = new CovidRecord();

                        LocalDate date = LocalDate.of();
                        covidRecord.setDate(date);
                        break;
                    case "cases":
                        break;
                    case "deaths":
                        break;
                    case "countriesAndTerritories":
                        break;
                    case "popData2020":
                        break;
                    default:

                }

            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
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
