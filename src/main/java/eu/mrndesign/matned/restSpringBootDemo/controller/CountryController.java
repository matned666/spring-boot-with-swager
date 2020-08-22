package eu.mrndesign.matned.restSpringBootDemo.controller;

import eu.mrndesign.matned.restSpringBootDemo.model.RestResponse;
import eu.mrndesign.matned.restSpringBootDemo.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {


    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country/{code}")
    public RestResponse getCountryFromRestApi(@PathVariable String code) {
        return countryService.getCountryFromRestApi(code.toUpperCase());
    }

}
