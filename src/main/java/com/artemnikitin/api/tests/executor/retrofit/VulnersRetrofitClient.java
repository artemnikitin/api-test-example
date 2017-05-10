package com.artemnikitin.api.tests.executor.retrofit;

import com.artemnikitin.api.tests.model.VulnersRequest;
import com.artemnikitin.api.tests.model.VulnersResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface VulnersRetrofitClient {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("/api/v3/audit/audit/")
    Call<VulnersResponse.VulnersJson> getVulnerabilities(@Body VulnersRequest request);

}
