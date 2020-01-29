package com.example.panopticon_event_logger.network

import com.example.panopticon_event_logger.model.EventsLoggerModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface PanopticonRequests {

    @POST("event-log/")
    fun logEvent(@Header("key") AuthKey: String?, @Body event: EventsLoggerModel): Call<Any?>?

}