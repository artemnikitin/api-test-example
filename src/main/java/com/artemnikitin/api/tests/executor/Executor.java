package com.artemnikitin.api.tests.executor;

import com.artemnikitin.api.tests.config.Config;
import com.artemnikitin.api.tests.executor.retrofit.VulnersRetrofitClient;
import com.artemnikitin.api.tests.model.VulnersRequest;
import com.artemnikitin.api.tests.model.VulnersResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface Executor {

    public static OkHttpClient getDefaultOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    public static VulnersRetrofitClient getDefaultRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl(Config.getHost())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VulnersRetrofitClient.class);
    }

    public VulnersResponse getResponse(VulnersRequest request) throws IOException;

}
