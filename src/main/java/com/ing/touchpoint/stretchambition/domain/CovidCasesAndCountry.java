package com.ing.touchpoint.stretchambition.domain;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CovidCasesAndCountry implements Serializable {

    private String date;
    private String country;

    public CovidCasesAndCountry(String date, String country) {

        this.date = date;
        this.country = country;
    }
}
