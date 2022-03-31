package io.aets.WaterTaxationBackend.controller;

import io.aets.WaterTaxationBackend.model.Bill;
import io.aets.WaterTaxationBackend.model.Subscriber;
import io.aets.WaterTaxationBackend.service.BillService;
import io.aets.WaterTaxationBackend.service.SubscriberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subscriber")
public class SubscriberController {
    private final SubscriberService subscriberService;
    private final BillService billService;
    public SubscriberController(SubscriberService subscriberService, BillService billService) {
        this.subscriberService = subscriberService;
        this.billService = billService;
    }

    /* @GetMapping("/all")
    public ResponseEntity<List<Subscriber>> getAllSubscribers(){
        List<Subscriber> subscribers = subscriberService.findAllSubscribers();
        return new ResponseEntity<>(subscribers, HttpStatus.OK);
    } */

    // carousel-rtl
    @GetMapping("/all")
    public String showUserList(Model model) {
        List<Subscriber> subscribers = subscriberService.findAllSubscribers();
        model.addAttribute("subscribers", subscribers);
        return "carousel-rtl/index";
    }

    /* @GetMapping("/find/{id}")
    public ResponseEntity<Subscriber> getSubscriberById(@PathVariable("id") Long id){
        Subscriber subscriber = subscriberService.findSubscriberById(id);
        return new ResponseEntity<>(subscriber, HttpStatus.OK);
    } */

    @GetMapping("/find/{id}")
    public String getSubscriberById(@PathVariable("id") Long id, Model model){
        Subscriber subscriber = subscriberService.findSubscriberById(id);
        model.addAttribute("subscriber", subscriber);
        List<Bill> bills = billService.findBySubscriberId(id);
        model.addAttribute("bills", bills);
        return "dashboard-rtl/index";
    }

    /*
    @PostMapping("/add")
    public ResponseEntity<Subscriber> addSubscriber(@RequestBody Subscriber subscriber){
        Subscriber newSubscriber = subscriberService.addSubscriber(subscriber);
        return new ResponseEntity<>(newSubscriber, HttpStatus.CREATED);
    }
    */

    @GetMapping("/add")
    public String addSubscriberForm(Model model){
        model.addAttribute("subscriber", new Subscriber());
        return "checkout-rtl/subscriber";
    }

    @PostMapping("/save")
    public String addSubscriber(@ModelAttribute Subscriber subscriber, Model model){
        model.addAttribute("subscriber", subscriber);
        Subscriber newSubscriber = subscriberService.addSubscriber(subscriber);
        return "redirect:/subscriber/all";
    }

    @PutMapping("/update")
    public ResponseEntity<Subscriber> updateSubscriber(@RequestBody Subscriber subscriber){
        Subscriber updatedSubscriber = subscriberService.updateSubscriber(subscriber);
        return new ResponseEntity<>(updatedSubscriber, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubscriberById(@PathVariable("id") Long id){
        subscriberService.deleteSubscriber(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
