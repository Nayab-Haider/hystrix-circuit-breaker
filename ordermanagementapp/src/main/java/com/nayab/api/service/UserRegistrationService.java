package com.nayab.api.service;

import com.nayab.api.dto.SellerDto;

import java.util.List;


public interface UserRegistrationService {
    String registerSeller(SellerDto sellerDto);

    List<SellerDto> getSellersList();
}
