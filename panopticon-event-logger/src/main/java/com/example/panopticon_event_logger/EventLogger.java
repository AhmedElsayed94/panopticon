package com.example.panopticon_event_logger;

import android.os.Build;
import android.util.Log;

import java.util.HashMap;

public class EventLogger {

    //required parameters
    private String baseUrl ;
    private String authKey ;


    public EventLogger(String baseUrl, String authKey) {
        this.baseUrl = baseUrl;
        this.authKey = authKey;
    }

    public void logEvent (EventLoggerModel event){
        Log.d("event",baseUrl);
        Log.d("event",authKey);
        Log.d("event",event.toString());
    }


}
