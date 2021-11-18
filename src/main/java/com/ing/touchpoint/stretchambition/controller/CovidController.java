package com.ing.touchpoint.stretchambition.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class CovidController {

    @Value("${url.covidJsonData}")
    private String url;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String getDataInJsonFormat() {
        // Make a URL to the web page
        try {
            URL url = new URL(this.url);
            InputStream content = url.openStream();
            FileWriter myWriter = new FileWriter("covid_json_data.txt");
            int c;
            while ((c = content.read())!=-1) {
                myWriter.write(c);
            }
            myWriter.close();

            System.out.println("\n Finished to read from " + url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return "index";
    }

}
