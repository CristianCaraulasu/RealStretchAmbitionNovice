package com.ing.touchpoint.stretchambition.repository;

import com.ing.touchpoint.stretchambition.domain.CovidCasesAndCountry;
import com.ing.touchpoint.stretchambition.domain.CovidRecord;
import org.springframework.data.repository.CrudRepository;

public interface CovidRepository extends CrudRepository<CovidRecord, CovidCasesAndCountry> {
}
