package com.ing.touchpoint.stretchambition.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
@IdClass(CovidCasesAndCountry.class)
public class CovidRecord {

    @Id
    private LocalDate date;
    @Id
    private String country;
    private int cases;
    private int deaths;
    private int population;

    public CovidRecord(){}

}
