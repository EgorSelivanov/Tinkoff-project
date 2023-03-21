package ru.tinkoff.edu.github;

import ru.tinkoff.edu.Response;

public record GitUserData(String user, String repository) implements Response {
    @Override
    public void printResponse() {
        System.out.println("User name: " + user);
        System.out.println("Repository: " + repository);
    }
}
