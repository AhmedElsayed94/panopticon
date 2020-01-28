package com.example.panopticon_event_logger.main

import android.util.Log
import com.example.panopticon_event_logger.model.EventLoggerModel
import com.example.panopticon_event_logger.utils.EventLoggerConstants

class EventLogger(private val baseUrl: String, private val authKey: String) {

    private val eventLoggerRequestManager: EventLoggerRequestManager

    init {
        EventLoggerConstants.baseUrl = baseUrl
        eventLoggerRequestManager = EventLoggerRequestManager()
    }

    fun logEvent(event: EventLoggerModel) {
        Log.d("event", baseUrl)
        Log.d("event", authKey)
        Log.d("event", event.toString())
        eventLoggerRequestManager.logEvent(authKey, event)
    }


}