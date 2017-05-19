package com.artemnikitin.api.tests.executor.retrofit;

import com.artemnikitin.api.tests.executor.Executor;
import com.artemnikitin.api.tests.model.VulnersRequest;
import com.artemnikitin.api.tests.model.VulnersResponse;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitExecutor implements Executor {

    private final VulnersRetrofitClient client;

    public RetrofitExecutor() {
        client = Executor.getDefaultRetrofitClient().create(VulnersRetrofitClient.class);
    }

    public RetrofitExecutor(VulnersRetrofitClient client) {
        this.client = client;
    }

    public VulnersResponse getResponse(VulnersRequest request) throws IOException {
        Response<VulnersResponse.VulnersJson> response = client.getVulnerabilities(request).execute();
        return new VulnersResponse(response.code(), response.body());
    }

}
