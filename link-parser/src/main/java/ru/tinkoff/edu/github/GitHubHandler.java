package ru.tinkoff.edu.github;

import ru.tinkoff.edu.LinkHandler;
import ru.tinkoff.edu.Response;

import java.net.URL;

public class GitHubHandler extends LinkHandler {
    @Override
    public Response handle(URL request) {
        if ("github.com".equals(request.getHost())) {
            String link = request.toString();
            if (link.contains("/"))
                link = link.replaceFirst("https://github.com/", "");
            else
                return null;
            if (!checkValidLink(link))
                return null;
            if (!link.contains("/"))
                return null;
            String name = link.substring(0, link.indexOf('/'));
            link = link.replaceFirst(name + "/", "");

            if (!checkValidLink(link))
                return null;

            String repository;
            if (link.contains("/"))
                repository = link.substring(0, link.indexOf('/'));
            else
                repository = link;

            return new GitUserData(name, repository);
        } else if (getNext() != null) {
            return getNext().handle(request);
        }
        return null;
    }

    private boolean checkValidLink(String link) {
        return !"".equals(link);
    }
}
