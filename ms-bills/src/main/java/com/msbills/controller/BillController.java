package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Bill>> getBillsByUserId(@PathVariable String id) {
        return ResponseEntity.ok().body(service.getBillsByUserId(id));
    }
    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('GROUP_/PROVIDERS')")
    public ResponseEntity<Bill> create(@RequestBody Bill bill) {
        return ResponseEntity.ok().body(this.service.createBill(bill));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Bill> getBillById( String id) {
        return ResponseEntity.ok().body(service.getBillById(id));
    }

}
