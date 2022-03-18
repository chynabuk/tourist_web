package org.example.services.Impl;

import org.example.dao.extd.CountryDao;
import org.example.entities.Country;
import org.example.enums.CountriesEnum;
import org.example.services.CountrySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountrySevice {
    @Autowired
    private CountryDao countryDao;

    @Override
    public void delete(Integer countryId) {
        countryDao.delete(countryId);
    }

    @Override
    public void insert(Country country) {
        countryDao.insert(country);
    }

    @Override
    public Country getBy(Integer countryId) {
        return countryDao.getBy(countryId);
    }

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }

    @Override
    public void addAll() {
        if (getAll().isEmpty()){
            Country c1 = new Country();
            c1.setCountriesEnum(CountriesEnum.KYRGYZSTAN);
            insert(c1);

            Country c2 = new Country();
            c2.setCountriesEnum(CountriesEnum.GERMANY);
            insert(c2);

            Country c3 = new Country();
            c3.setCountriesEnum(CountriesEnum.USA);
            insert(c3);
        }
    }
}
