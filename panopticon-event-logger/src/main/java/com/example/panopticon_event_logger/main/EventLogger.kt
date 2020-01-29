package com.example.panopticon_event_logger.main

import com.example.panopticon_event_logger.db.EventLoggerDbHelper
import com.example.panopticon_event_logger.model.EventLoggerModel
import com.example.panopticon_event_logger.model.EventsLoggerModel
import com.example.panopticon_event_logger.utils.EventLoggerConstants

class EventLogger(private val baseUrl: String, private val authKey: String) : EventLoggerContract.IEventLogger {

    private val eventLoggerRequestManager: EventLoggerRequestManager
    private val eventLoggerDbHelper = EventLoggerDbHelper

    init {
        EventLoggerConstants.baseUrl = baseUrl
        eventLoggerRequestManager = EventLoggerRequestManager(this)
    }

    fun logEvent(event: EventLoggerModel) {
        eventLoggerDbHelper.logEvent(event)
    }

    fun fireEventsToServer() {
        val logs = eventLoggerDbHelper.getLogs()
        if (logs.size >= EventLoggerConstants.LOGS_LIMIT) {
            var eventsLoggerModel = EventsLoggerModel()
            eventsLoggerModel.logs = logs
            eventLoggerRequestManager.logEvent(authKey, eventsLoggerModel)
        }
    }

    fun setLogsLimit(limit : Long){
        EventLoggerConstants.LOGS_LIMIT = limit
    }

    override fun onSuccess() {
        EventLoggerDbHelper.deleteFromDatabase()
        fireEventsToServer()
    }

    override fun onError() {
         // something wrong happened
    }

}