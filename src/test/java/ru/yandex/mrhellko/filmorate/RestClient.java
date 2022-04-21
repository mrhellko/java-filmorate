package ru.yandex.mrhellko.filmorate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient {
    private final String server = "http://localhost:8080";
    private final RestTemplate rest;
    private final HttpHeaders headers;

    public RestClient() {
        rest = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    public Response get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
        return new Response(responseEntity.getStatusCode().value(), requestEntity.getBody());
    }

    public Response post(String uri, String json) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.POST, requestEntity, String.class);
        return new Response(responseEntity.getStatusCode().value(), requestEntity.getBody());
    }

    public Response put(String uri, String json) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
        ResponseEntity<Response> responseEntity = rest.exchange(server + uri, HttpMethod.PUT, requestEntity, Response.class);
        return new Response(responseEntity.getStatusCode().value(), requestEntity.getBody());
    }
}
record Response(int status, String body) {}
