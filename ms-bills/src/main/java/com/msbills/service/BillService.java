package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public Bill getBillById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Bill> getBillsByUserId(String id) {
        return repository.getBillsByUserId(id);
    }


    public Bill createBill(Bill bill) {
        return repository.save(bill);
    }

}
