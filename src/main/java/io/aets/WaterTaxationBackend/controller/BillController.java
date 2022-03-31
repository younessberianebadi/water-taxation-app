package io.aets.WaterTaxationBackend.controller;

import io.aets.WaterTaxationBackend.model.Bill;
import io.aets.WaterTaxationBackend.model.Subscriber;
import io.aets.WaterTaxationBackend.service.BillService;
import io.aets.WaterTaxationBackend.service.SubscriberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    private final BillService billService;
    private final SubscriberService subscriberService;

    public BillController(BillService billService, SubscriberService subscriberService) {
        this.billService = billService;
        this.subscriberService = subscriberService;
    }

    @GetMapping("/add/{id}")
    public String addBillForm(@PathVariable("id") Long id, Model model){
        Subscriber subscriber = subscriberService.findSubscriberById(id);
        Bill newBill = new Bill();
        newBill.setOld_date(subscriber.getLast_checked());
        newBill.setOld_value(subscriber.getLast_value());
        newBill.setSubscriberId(subscriber.getId());
        // long millis = System.currentTimeMillis();
        newBill.setDate(new Date());
        // System.out.println(new Date(millis));
        model.addAttribute("bill", newBill);
        model.addAttribute("subscriber", subscriber);
        // List<Subscriber> subscribers = subscriberService.findAllSubscribers();
        // model.addAttribute("subscribers", subscribers);
        return "checkout-rtl/index";
    }

    @PostMapping("/save")
    public String addBill(@ModelAttribute Bill bill, Model model){
        model.addAttribute("bill", bill);
        Subscriber subscriber = subscriberService.findSubscriberById(bill.getSubscriberId());
        subscriber.setLast_value(bill.getNew_value());
        subscriber.setLast_checked(bill.getDate());
        Bill newBill = billService.addBill(bill);
        return "redirect:/subscriber/all";
    }

    @GetMapping("/find/{id}")
    public String getBillById(@PathVariable("id") Long id, Model model){
        Bill bill = billService.findBillById(id);
        model.addAttribute("bill", bill);
        Subscriber subscriber = subscriberService.findSubscriberById(bill.getSubscriberId());
        model.addAttribute("subscriber", subscriber);
        return "bill/index";
    }
}
