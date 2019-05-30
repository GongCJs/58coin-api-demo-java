package com.coin58.api.client;

import com.coin58.api.client.impl.ApiAsyncRestClientImpl;
import com.coin58.api.client.impl.ApiRestClientImpl;
import com.coin58.api.client.impl.ApiServiceGenerator;
import com.coin58.api.client.impl.ApiSocketClientImpl;

/**
 * A factory for creating 58coin Api client objects.
 */
public class ApiClientFactory {

    private String apiKey;

    private String apiSecret;

    private ApiClientFactory(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public static ApiClientFactory newInstance(String apiKey, String apiSecret) {
        return new ApiClientFactory(apiKey, apiSecret);
    }

    public static ApiClientFactory newInstance() {
        return new ApiClientFactory(null, null);
    }

    public ApiRestClient newRestClient() {
        return new ApiRestClientImpl(apiKey, apiSecret);
    }

    public ApiAsyncRestClient newAsyncRestClient() {
        return new ApiAsyncRestClientImpl(apiKey, apiSecret);
    }

    public ApiSocketClient newWebSocketClient() {
        return new ApiSocketClientImpl(this.apiKey, this.apiSecret, ApiServiceGenerator.getSharedClient());
    }

}