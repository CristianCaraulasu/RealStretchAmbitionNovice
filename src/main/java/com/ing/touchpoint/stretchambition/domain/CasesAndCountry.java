package com.ing.touchpoint.stretchambition.domain;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CasesAndCountry implements Serializable {

    private String date;
    private String country;

    public CasesAndCountry(String date, String country) {

        this.date = date;
        this.country = country;
    }
}
