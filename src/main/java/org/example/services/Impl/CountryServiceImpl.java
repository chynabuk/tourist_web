package org.example.services.Impl;

import org.example.dao.extd.CountryDao;
import org.example.entities.Country;
import org.example.enums.CountriesEnum;
import org.example.services.CountrySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
        if (getAll().isEmpty() || getAll() == null){
            for (CountriesEnum countriesEnum : CountriesEnum.values()){
                Country country = new Country();
                country.setCountriesEnum(countriesEnum);
                insert(country);
            }
        }
    }
}
