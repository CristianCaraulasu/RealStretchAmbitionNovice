package com.ing.touchpoint.stretchambition.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class CovidCasesAndCountry implements Serializable {

    private LocalDate date;
    private String country;

    public CovidCasesAndCountry(LocalDate date, String country) {

        this.date = date;
        this.country = country;
    }
    public CovidCasesAndCountry(){}
}
