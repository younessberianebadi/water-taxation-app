package io.aets.WaterTaxationBackend.exception;

public class SubscriberNotFoundException extends RuntimeException{
    public SubscriberNotFoundException(String message) {
        super(message);
    }
}
