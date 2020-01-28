package com.example.panopticon_event_logger.network;


import com.example.panopticon_event_logger.model.EventLoggerModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface PanopticonRequests {

    @POST("event-log/")
    Call<Object> logEvent( @Header("auth_key") String AuthKey ,@Body EventLoggerModel event);

}
