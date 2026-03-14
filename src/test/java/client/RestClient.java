package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import types.RequestMethodType;

public class RestClient {
    //Trebuie sa fac doua actiuni pe aceasta clasa
    //Trebuie sa configurez clientul
    //Pe baza configurarilor trebuie sa pot sa execut orice actiune (get, post, put, delete)


    public Response performRequest(String requestType, RequestSpecification request, String endpoint) {
        switch (requestType) {
            case RequestMethodType.REQUEST_POST:
                return prepareClient(request).post(endpoint);
            case RequestMethodType.REQUEST_PUT:
                return prepareClient(request).put(endpoint);
            case RequestMethodType.REQUEST_GET:
                return prepareClient(request).get(endpoint);
            case RequestMethodType.REQUEST_DELETE:
                return prepareClient(request).delete(endpoint);
        }
        return null;
    }

    public RequestSpecification prepareClient(RequestSpecification request){
        request.baseUri("https://api.practicesoftwaretesting.com");
        request.header("Content-type", "application/json");
        request.header("Accept", "application/json");
        return request;
    }
}