package com.example.panopticon_event_logger

import android.util.Log

class EventLogger {

   private val TAG = "logevent"

    fun logEvent(event: String) {

        Log.d(TAG,event)

    }

}