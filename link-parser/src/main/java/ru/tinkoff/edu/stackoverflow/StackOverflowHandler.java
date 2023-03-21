package ru.tinkoff.edu.stackoverflow;

import ru.tinkoff.edu.LinkHandler;
import ru.tinkoff.edu.Response;

import java.net.URL;

public class StackOverflowHandler extends LinkHandler {
    @Override
    public Response handle(URL request) {
        if ("stackoverflow.com".equals(request.getHost())) {
            String link = request.toString();

            if (link.contains("/"))
                link = link.replaceFirst("https://stackoverflow.com/", "");
            else
                return null;

            if (link.contains("questions/"))
                link = link.replaceFirst("questions/", "");
            else
                return null;

            if ("".equals(link))
                return null;

            if (link.contains("/"))
                link = link.substring(0, link.indexOf('/'));

            long id;
            try {
                id = Long.parseLong(link);
            } catch (Exception ex) {
                return null;
            }

            return new StackOverflowData(id);
        } else if (getNext() != null) {
            return getNext().handle(request);
        }
        return null;
    }
}
