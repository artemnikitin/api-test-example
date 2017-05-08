package com.artemnikitin.api.tests.retrofit;

import com.artemnikitin.api.tests.model.VulnersRequest;
import com.artemnikitin.api.tests.model.VulnersResponse;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitExecutor {

    private static final VulnersRetrofitClient client = new Retrofit.Builder()
            .baseUrl("https://vulners.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VulnersRetrofitClient.class);

    public static Response<VulnersResponse> getResponse(VulnersRequest request) throws IOException {
        return client.getVulnerabilities(request).execute();
    }

}
