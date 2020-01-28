package com.example.panopticon_event_logger.network;

import androidx.annotation.NonNull;

import com.example.panopticon_event_logger.utils.EventLoggerConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventLoggerApiManager {

    private static Retrofit retrofit;
    private static PanopticonRequests service;

    private EventLoggerApiManager() {
    }

    public static PanopticonRequests getClient() {
        if (retrofit == null) {
            Interceptor interceptor = getInterceptor();

            OkHttpClient.Builder httpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient().newBuilder();
            httpClient.addInterceptor(interceptor);

            HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
            logger.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            logger.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logger);
            httpClient.connectTimeout(15, TimeUnit.SECONDS); // connect timeout
            httpClient.readTimeout(15, TimeUnit.SECONDS);

            retrofit = new Retrofit.Builder()
                    .baseUrl(getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            service = retrofit.create(PanopticonRequests.class);
        }
        return service;
    }

    @NonNull
    private static Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {
                return chain.proceed(getBuilder(chain).build());
            }
        };
    }

    private static Request.Builder getBuilder(@NonNull Interceptor.Chain chain) {
        Request original = chain.request();
        Request.Builder builder = original.newBuilder()
                .method(original.method(), original.body());

        return builder;
    }


    public static String getBaseUrl() {
        return EventLoggerConstants.getBaseUrl();
    }

}
