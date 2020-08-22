package eu.mrndesign.matned.restSpringBootDemo.service;

import eu.mrndesign.matned.restSpringBootDemo.model.RestResponse;
import eu.mrndesign.matned.restSpringBootDemo.model.RootObject;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Locale;

@Service
public class CountryService {

    private static final String URL = "http://www.groupkt.com/country/get/iso2code/";

    private RestTemplate restTemplate;

    private MessageSource messageSource;

    public CountryService(RestTemplate restTemplate, MessageSource messageSource) {
        this.restTemplate = restTemplate;
        this.messageSource = messageSource;
    }

    public RestResponse getCountryFromRestApi(String code){
        ResponseEntity<RootObject> response = getDataFromApi(code);
        if(response.getStatusCode().is2xxSuccessful()) {
            RestResponse restResponse = response.getBody().getRestResponse();
            String sayDupa = messageSource.getMessage("hello.message", null, Locale.forLanguageTag(code));
            restResponse.getResult().setSayDupa(sayDupa);
            return restResponse;
        }else return null;
    }

    private ResponseEntity<RootObject> getDataFromApi(String code) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(URL+code)
                .build()
                .toUri();
        return restTemplate.getForEntity(uri, RootObject.class);
    }
}
