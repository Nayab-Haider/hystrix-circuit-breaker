package com.nayab.api.service;

import com.nayab.api.dto.SellerDto;

import java.util.List;


public interface RegistrationService {


    String addSeller(SellerDto sellerDto);

    List<SellerDto> getSellersList();
}
