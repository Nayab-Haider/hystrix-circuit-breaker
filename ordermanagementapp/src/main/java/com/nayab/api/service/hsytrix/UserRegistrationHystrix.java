package com.nayab.api.service.hsytrix;

import com.nayab.api.dto.SellerDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserRegistrationHystrix {
    Logger logger = LoggerFactory.getLogger(UserRegistrationHystrix.class);
    private RestTemplate restTemplate;

    public UserRegistrationHystrix(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallbackForRegisterSeller", commandKey = "ordermanagement")
    public String registerSeller(SellerDto sellerDto) {
        String response = restTemplate.postForObject("/addSeller", sellerDto, String.class);
        return response;
    }

    @HystrixCommand(fallbackMethod = "fallbackForgetSellersList", commandKey = "ordermanagement")
    public List<SellerDto> getSellersList() {
        return restTemplate.getForObject("/sellersList", List.class);
    }

    public String fallbackForRegisterSeller(SellerDto sellerDto, Throwable t) {
        logger.error("Inside fall back, cause - {}", t.toString());
        return "Inside fallback method. Some error occured while calling service for seller registration";
    }

    public List<SellerDto> fallbackForgetSellersList(Throwable t) {
        logger.error("Inside fall back, cause - {}", t.toString());
        ArrayList<SellerDto> list = new ArrayList<>();
        list.add(new SellerDto());
        return list;
    }
}
