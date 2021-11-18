package com.ing.touchpoint.stretchambition.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
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
@IdClass(CasesAndCountry.class)
public class Record {

    @Id
    private LocalDate date;
    @Id
    private String country;
    private int cases;
    private int deaths;
    private int population;

    public Record(){}

}
