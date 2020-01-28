package com.example.panopticon_event_logger.main

import com.example.panopticon_event_logger.db.EventLoggerDbHelper
import com.example.panopticon_event_logger.model.EventLoggerModel
import com.example.panopticon_event_logger.model.EventsLoggerModel
import com.example.panopticon_event_logger.network.EventLoggerApiManager
import com.example.panopticon_event_logger.network.PanopticonRequests
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventLoggerRequestManager {

    private val panopticonRequests: PanopticonRequests? = EventLoggerApiManager.client

    fun logEvent(authKey: String?, eventsLoggerModel: EventsLoggerModel) {
        val call = panopticonRequests!!.logEvent(authKey, eventsLoggerModel)
        call!!.enqueue(object : Callback<Any?> {
            override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                if (response.isSuccessful){
                    EventLoggerDbHelper.deleteFromDatabase()
                }
            }
            override fun onFailure(call: Call<Any?>, t: Throwable) {

            }
        })
    }

}