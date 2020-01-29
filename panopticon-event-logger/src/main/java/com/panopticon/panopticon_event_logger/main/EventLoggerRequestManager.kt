package com.panopticon.panopticon_event_logger.main

import com.panopticon.panopticon_event_logger.db.EventLoggerDbHelper
import com.panopticon.panopticon_event_logger.model.EventsLoggerModel
import com.panopticon.panopticon_event_logger.network.EventLoggerApiManager
import com.panopticon.panopticon_event_logger.network.PanopticonRequests
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventLoggerRequestManager(val eventlogger : EventLoggerContract.IEventLogger) : EventLoggerContract.IRequestManager{

    private val panopticonRequests: PanopticonRequests? = EventLoggerApiManager.client
    private var logger: EventLoggerContract.IEventLogger


    init {
        logger = eventlogger
    }


    override fun logEvent(authKey: String?, eventsLoggerModel: EventsLoggerModel) {
        val call = panopticonRequests!!.logEvent(authKey, eventsLoggerModel)
        call!!.enqueue(object : Callback<Any?> {
            override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                if (response.isSuccessful){
                    logger.onSuccess()
                }
                else {
                    logger.onError()
                }
            }
            override fun onFailure(call: Call<Any?>, t: Throwable) {
                logger.onError()
            }
        })
    }

}