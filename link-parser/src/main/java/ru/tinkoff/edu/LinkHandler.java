package ru.tinkoff.edu;

import java.net.URL;

public abstract class LinkHandler implements Handler{
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler handler) {
        next = handler;
    }

    public Response handle(URL request) {
        return null;
    }
}
