package io.aets.WaterTaxationBackend.service;

import io.aets.WaterTaxationBackend.exception.BillNotFoundException;
import io.aets.WaterTaxationBackend.model.Bill;
import io.aets.WaterTaxationBackend.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill addBill(Bill bill){
        bill.setBill_serial_number(UUID.randomUUID().toString());
        return billRepository.save(bill);
    }

    public List<Bill> findAllBills(){
        return billRepository.findAll();
    }

    public Bill updateBill(Bill bill){
        return billRepository.save(bill);
    }

    public Bill findBillById(Long id){
        return billRepository.findBillById(id).orElseThrow(() -> new BillNotFoundException("Bill by id" + id + "was not found!"));
    }

    public List<Bill> findBySubscriberId(Long subscriberId){
        return billRepository.findBySubscriberId(subscriberId);
                //.orElseThrow(() -> new BillNotFoundException("Bills for subscriber " + subscriberId + "was not found!"));
    }

    public void deleteBill(Long id){
        billRepository.deleteBillById(id);
    }

    public void deleteBySubscriberId(Long subscriberId){
        List<Bill> bills = billRepository.findBySubscriberId(subscriberId);
        for (int i = 0; i < bills.size(); i++) {
            billRepository.deleteBillById(bills.get(i).getId());
        }
    }
}
