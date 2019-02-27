package com.uyummedia.service.twitter.it.config;

import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class SecureMockServerClient extends MockServerClient {
    SecureMockServerClient(String host, int port) {
        super(host, port);
    }

    @Override
    protected HttpResponse sendRequest(HttpRequest request) {
        return super.sendRequest(request.withSecure(true));
    }
}
