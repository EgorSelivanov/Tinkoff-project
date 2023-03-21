package ru.tinkoff.edu.stackoverflow;

import ru.tinkoff.edu.Response;

public record StackOverflowData(long id) implements Response {
    @Override
    public void printResponse() {
        System.out.println("Question id: " + id);
    }
}
