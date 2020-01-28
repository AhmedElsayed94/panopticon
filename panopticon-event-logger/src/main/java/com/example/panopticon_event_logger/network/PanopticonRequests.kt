package com.example.panopticon_event_logger.network

import com.example.panopticon_event_logger.model.EventLoggerModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface PanopticonRequests {

    @POST("event-log/")
    fun logEvent(@Header("auth_key") AuthKey: String?, @Body event: EventLoggerModel?): Call<Any?>?

}