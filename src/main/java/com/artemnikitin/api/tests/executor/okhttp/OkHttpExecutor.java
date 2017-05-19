package com.artemnikitin.api.tests.executor.okhttp;

import com.artemnikitin.api.tests.config.Config;
import com.artemnikitin.api.tests.executor.Executor;
import com.artemnikitin.api.tests.model.VulnersRequest;
import com.artemnikitin.api.tests.model.VulnersResponse;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class OkHttpExecutor implements Executor {

    private final OkHttpClient client;

    public OkHttpExecutor() {
        client = Executor.getDefaultOkHttpClient();
    }

    public OkHttpExecutor(OkHttpClient client) {
        this.client = client;
    }

    public VulnersResponse getResponse(VulnersRequest request) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                gson.toJson(request));
        Request req = new Request.Builder()
                .url(Config.getUrl())
                .post(body)
                .build();
        Response response = client.newCall(req).execute();
        VulnersResponse result = new VulnersResponse(
                response.code(),
                gson.fromJson(response.body().string(), VulnersResponse.VulnersJson.class));
        return result;
    }

}
