package ru.tinkoff.edu;

import ru.tinkoff.edu.github.GitHubHandler;
import ru.tinkoff.edu.stackoverflow.StackOverflowHandler;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        URL url;
        try {
            url = new URL("https://github.com/sanyarnd/tinkoff-java-course-2022/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        LinkHandler handler1 = new GitHubHandler();
        LinkHandler handler2 = new StackOverflowHandler();
        handler1.setNext(handler2);

        Response response = handler1.handle(url);
        if (response != null)
            response.printResponse();
        else
            System.out.println("null");
    }
}
