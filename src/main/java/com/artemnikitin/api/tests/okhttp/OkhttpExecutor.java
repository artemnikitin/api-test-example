package com.artemnikitin.api.tests.okhttp;

import com.google.gson.Gson;

import com.artemnikitin.api.tests.config.Config;
import com.artemnikitin.api.tests.model.VulnersRequest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpExecutor {

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build();

    public static Response getResponse(VulnersRequest request) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                gson.toJson(request));
        Request req = new Request.Builder()
                .url(Config.getUrl())
                .post(body)
                .build();
        return client.newCall(req).execute();
    }

}
