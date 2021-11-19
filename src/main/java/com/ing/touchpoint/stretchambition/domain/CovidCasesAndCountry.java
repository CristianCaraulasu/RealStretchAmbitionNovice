package com.ing.touchpoint.stretchambition.domain;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CovidCasesAndCountry implements Serializable {

    private String dateRep;
    private String countriesAndTerritories;

    public CovidCasesAndCountry(String dateRep, String countriesAndTerritories) {

        this.dateRep = dateRep;
        this.countriesAndTerritories = countriesAndTerritories;
    }
}
