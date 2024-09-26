package dev.mahfuj.annotationProcessing;

public class Command<T> {

    private T payload;

    public Command(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}
