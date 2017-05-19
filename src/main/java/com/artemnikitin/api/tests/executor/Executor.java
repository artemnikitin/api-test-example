package com.artemnikitin.api.tests.executor;

import com.artemnikitin.api.tests.config.Config;
import com.artemnikitin.api.tests.model.VulnersRequest;
import com.artemnikitin.api.tests.model.VulnersResponse;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public interface Executor {

    static OkHttpClient getDefaultOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    static Retrofit getDefaultRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl(Config.getHost())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    VulnersResponse getResponse(VulnersRequest request) throws IOException;

}
