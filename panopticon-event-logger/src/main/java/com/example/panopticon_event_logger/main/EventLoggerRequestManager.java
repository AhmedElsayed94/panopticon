package com.example.panopticon_event_logger.main;

import androidx.annotation.NonNull;

import com.example.panopticon_event_logger.model.EventLoggerModel;
import com.example.panopticon_event_logger.network.EventLoggerApiManager;
import com.example.panopticon_event_logger.network.PanopticonRequests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventLoggerRequestManager {

    private PanopticonRequests panopticonRequests;

    public EventLoggerRequestManager() {
        panopticonRequests = EventLoggerApiManager.getClient();
    }

    public void logEvent(String authKey , EventLoggerModel eventLoggerModel) {
        Call<Object> call = panopticonRequests.logEvent(authKey,eventLoggerModel);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
            }

            @Override
            public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
            }
        });
    }

}
