package com.chenyuan.sentence.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class ServiceFactory {

    private final static long DEFAULT_TIMEOUT = 10;

    public ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T createService(Class<T> serviceClass, String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .build();
        return retrofit.create(serviceClass);
    }

    private OkHttpClient getOkHttpClient() {
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor());
        //设置超时时间
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        return httpClientBuilder.build();
    }

    private static class SingletonHolder {

        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}