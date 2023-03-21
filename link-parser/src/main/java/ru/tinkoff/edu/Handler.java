package ru.tinkoff.edu;

import java.net.URL;

public interface Handler {
    Handler getNext();
    void setNext(Handler handler);

    Response handle(URL request);
}
