package io.aets.WaterTaxationBackend.service;

import io.aets.WaterTaxationBackend.exception.SubscriberNotFoundException;
import io.aets.WaterTaxationBackend.model.Subscriber;
import io.aets.WaterTaxationBackend.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Subscriber addSubscriber(Subscriber subscriber){
        subscriber.setSubscriberCode(UUID.randomUUID().toString());
        return subscriberRepository.save(subscriber);
    }

    public List<Subscriber> findAllSubscribers(){
        return subscriberRepository.findAll();
    }

    public Subscriber updateSubscriber(Subscriber subscriber){
        return subscriberRepository.save(subscriber);
    }

    public Subscriber findSubscriberById(Long id){
        return subscriberRepository.findSubscriberById(id).orElseThrow(() -> new SubscriberNotFoundException("Subscriber by id" + id + "was not found!"));
    }

    public void deleteSubscriber(Long id){
        subscriberRepository.deleteSubscriberById(id);
    }
}
