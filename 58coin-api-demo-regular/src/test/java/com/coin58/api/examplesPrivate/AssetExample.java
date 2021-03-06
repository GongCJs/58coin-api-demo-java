package com.coin58.api.examplesPrivate;

import com.coin58.api.client.ApiClientFactory;
import com.coin58.api.client.ApiRestClient;
import com.coin58.api.client.domain.AssetResponse;

/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/3/13 15:17
 * @description Term contract - account - user assets
 * @modify
 */
public class AssetExample {
    public static void main(String[] args) {
        String apiKey = "6616146f-6fe6-447c-bd31-c346437f201b";
        String apiSecret = "E4199FA0CD19F4996A3D78E226ACAF2D";
        ApiClientFactory factory = ApiClientFactory.newInstance(apiKey, apiSecret);
        ApiRestClient client = factory.newRestClient();

        AssetResponse assets = client.getAsset(2001l);
        System.out.println(assets);
    }
}
