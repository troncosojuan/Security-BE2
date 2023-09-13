package com.example.msusers.service;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import com.example.msusers.repository.FeignBillRepository;
import com.example.msusers.repository.KeycloakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private KeycloakRepository userRepository;
    @Autowired
    private FeignBillRepository feignBillRepository;


    public User getUserById(String id) {
        User user = userRepository.findByUserId(id);
        List<Bill> bills = feignBillRepository.getBillsByUserId(id).getBody();
        user.setBills(bills);
        return user;
    }


}
