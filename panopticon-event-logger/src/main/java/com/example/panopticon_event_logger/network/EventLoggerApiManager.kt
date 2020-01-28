package com.example.panopticon_event_logger.network

import com.example.panopticon_event_logger.utils.EventLoggerConstants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object EventLoggerApiManager {
    private var retrofit: Retrofit? = null
    private var service: PanopticonRequests? = null
    // connect timeout
    val client: PanopticonRequests?
        get() {
            if (retrofit == null) {
                val interceptor = interceptor
                val httpClient =
                    UnsafeOkHttpClient.unsafeOkHttpClient.newBuilder()
                httpClient.addInterceptor(interceptor)
                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.HEADERS
                logger.level = HttpLoggingInterceptor.Level.BODY
                httpClient.addInterceptor(logger)
                httpClient.connectTimeout(15, TimeUnit.SECONDS) // connect timeout
                httpClient.readTimeout(15, TimeUnit.SECONDS)
                retrofit = Retrofit.Builder()
                    .baseUrl(EventLoggerConstants.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                service =
                    retrofit!!.create(
                        PanopticonRequests::class.java
                    )
            }
            return service
        }

    private val interceptor: Interceptor
        private get() = Interceptor { chain -> chain.proceed(getBuilder(chain).build()) }

    private fun getBuilder(chain: Interceptor.Chain): Request.Builder {
        val original = chain.request()
        return original.newBuilder()
            .method(original.method(), original.body())
    }
}