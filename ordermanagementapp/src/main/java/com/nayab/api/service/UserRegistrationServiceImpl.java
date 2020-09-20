package com.nayab.api.service;

import com.nayab.api.dto.SellerDto;
import com.nayab.api.service.hsytrix.UserRegistrationHystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
    private UserRegistrationHystrix userRegistrationHystrix;


    public UserRegistrationServiceImpl(UserRegistrationHystrix userRegistrationHystrix) {
        this.userRegistrationHystrix = userRegistrationHystrix;
    }

    @Override
    public String registerSeller(SellerDto sellerDto) {
        long start = System.currentTimeMillis();
        String registerSeller = userRegistrationHystrix.registerSeller(sellerDto);
        logger.info("add seller call returned in - {}", System.currentTimeMillis() - start);
        return registerSeller;

    }

    @Override
    public List<SellerDto> getSellersList() {
        return userRegistrationHystrix.getSellersList();
    }
}
