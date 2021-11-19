package com.ing.touchpoint.stretchambition.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@AllArgsConstructor
@Entity
@IdClass(CovidCasesAndCountry.class)
public class CovidRecord {

    @Id
    private String dateRep;
    private String day;
    private String month;
    private String year;
    private String cases;
    private String deaths;
    @Id
    private String countriesAndTerritories;
    private String popData2020;
    private String continentExp;

    public CovidRecord(){}

}
