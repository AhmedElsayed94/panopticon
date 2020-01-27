package com.example.panopticon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.panopticon_event_logger.EventLogger
import com.example.panopticon_event_logger.EventLoggerModel.EventLoggerBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val eventLogger = EventLogger("www.test.com","ACES125A")
        test(eventLogger)
    }

    private fun test(eventLogger : EventLogger ) {
        val eventLoggerModel = EventLoggerBuilder()
            .setIp("192.168.1.1")
            .setAppId("CHSZKJ")
            .setAppName("Panopticon")
            .setEventName("main_screen")
            .setUserId(13)
            .setUserType("Super User")
            .setDeviceModel("A10")
            .setDeviceId("AHJXKKK55")
            .setLogTime("00:00:00")
            .setEventData(null)
            .setAppVersion("1.0.0")
            .build()

        eventLogger.logEvent(eventLoggerModel)

    }
}
