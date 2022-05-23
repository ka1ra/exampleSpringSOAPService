package com.example.demosoapserver;

import com.ka1ra.springsoap.gen.Country;
import com.ka1ra.springsoap.gen.Currency;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country germany = new Country();
        germany.setName("Germany");
        germany.setCapital("Berlin");
        germany.setPopulation(83_783_942);
        germany.setCurrency(Currency.EUR);
        countries.put("germany", germany);

        Country england = new Country();
        england.setName("England");
        england.setCapital("London");
        england.setPopulation(67_886_011);
        england.setCurrency(Currency.GBP);
        countries.put("england", england);

        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setPopulation(46_754_778);
        spain.setCurrency(Currency.EUR);
        countries.put("spain", spain);

        Country france = new Country();
        france.setName("France");
        france.setCapital("Paris");
        france.setPopulation(65_273_511);
        france.setCurrency(Currency.EUR);
        countries.put("france", france);

        Country italy = new Country();
        italy.setName("Italy");
        italy.setCapital("Rome");
        italy.setPopulation(60_461_826);
        italy.setCurrency(Currency.EUR);
        countries.put("italy", italy);
    }

    public Country findCountry(String name) {
        return this.countries.get(name);
    }

}
