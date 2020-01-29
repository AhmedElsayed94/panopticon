package com.panopticon.panopticon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.panopticon.R
import com.panopticon.panopticon_event_logger.base.Panopticon
import com.panopticon.panopticon_event_logger.main.EventLogger
import com.panopticon.panopticon_event_logger.model.EventLoggerModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Panopticon(this)
        val eventLogger = EventLogger(
            "http://test.com/",
            "ACES125A"
        )
        eventLogger.setLogsLimit(3)
        test(eventLogger)
        eventLogger.fireEventsToServer()
    }

    private fun test(eventLogger : EventLogger) {
        val eventLoggerModel = EventLoggerModel.EventLoggerBuilder()
            .setIp("192.168.1.1")
            .setAppId("CHSZKJ")
            .setAppName("Panopticon")
            .setEventName("main_screen")
            .setUserId(13)
            .setUserType("Super User")
            .setDeviceModel("A10")
            .setDeviceId("AHJXKKK55")
            .setLogTime("00:00:00")
            .setEventData("{test,test}")
            .setAppVersion("1.0.0")
            .build()

        eventLogger.logEvent(eventLoggerModel)

    }
}
