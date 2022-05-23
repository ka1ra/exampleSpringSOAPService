package com.example.demosoapserver;

import com.ka1ra.springsoap.gen.GetCountryRequest;
import com.ka1ra.springsoap.gen.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    public static final String NAMESPACE_URI = "http://www.ka1ra.com/springsoap/gen";

    private CountryRepository countryRepository;

    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /*
    * @Endpoint – registers the class with Spring WS as a Web Service Endpoint
    * @PayloadRoot – defines the handler method according to the namespace and localPart attributes
    * @ResponsePayload – indicates that this method returns a value to be mapped to the response payload
    * @RequestPayload – indicates that this method accepts a parameter to be mapped from the incoming request
    * */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

}
