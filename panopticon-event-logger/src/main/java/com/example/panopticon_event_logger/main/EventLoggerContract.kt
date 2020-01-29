package com.example.panopticon_event_logger.main

import com.example.panopticon_event_logger.model.EventsLoggerModel

interface EventLoggerContract {

    interface IRequestManager {
        fun logEvent(authKey: String?, eventsLoggerModel: EventsLoggerModel)
    }

    interface IEventLogger {
        fun onSuccess()
        fun onError()
    }
}