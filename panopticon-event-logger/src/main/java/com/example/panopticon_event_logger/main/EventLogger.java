package com.example.panopticon_event_logger.main;

import android.util.Log;

import com.example.panopticon_event_logger.model.EventLoggerModel;
import com.example.panopticon_event_logger.utils.EventLoggerConstants;

public class EventLogger {

    //required parameters
    private String baseUrl ;
    private String authKey ;
    private EventLoggerRequestManager eventLoggerRequestManager;


    public EventLogger(String baseUrl, String authKey) {
        this.baseUrl = baseUrl;
        this.authKey = authKey;
        EventLoggerConstants.setBaseUrl(baseUrl);
        eventLoggerRequestManager = new EventLoggerRequestManager();
    }

    public void logEvent (EventLoggerModel event){
        Log.d("event",baseUrl);
        Log.d("event",authKey);
        Log.d("event",event.toString());
        eventLoggerRequestManager.logEvent(authKey,event);
    }


}
