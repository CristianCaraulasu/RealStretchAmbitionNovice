package com.ing.touchpoint.stretchambition.controller;


import com.ing.touchpoint.stretchambition.domain.CovidRecord;
import com.ing.touchpoint.stretchambition.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
            FileWriter myWriter = new FileWriter("covid_json_data.txt");
            int c;
            int counter = 1;
            System.out.print("Still reading json data");
            while ((c = content.read())!=-1) {
                myWriter.write(c);
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
            }
            myWriter.close();

            System.out.println("\nFinished to read from " + url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return "index.html";
    }

}
