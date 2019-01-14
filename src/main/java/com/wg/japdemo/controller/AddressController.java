package com.wg.japdemo.controller;

import com.wg.japdemo.domain.Address;
import com.wg.japdemo.domain.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wanggang.io
 * @Date: 2018/12/14 14:01
 * @todo
 */
@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("get")
    public Address getAddress(Long id){
        return addressRepository.findById(id).get();
    }
}
