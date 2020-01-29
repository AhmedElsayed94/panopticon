package com.example.panopticon_event_logger.db

import android.util.Log
import com.example.panopticon_event_logger.model.EventLoggerModel
import com.example.panopticon_event_logger.model.LoggerRealmObject
import com.example.panopticon_event_logger.utils.EventLoggerConstants.LOGS_LIMIT
import io.realm.Realm
import java.util.*
import kotlin.collections.ArrayList

object EventLoggerDbHelper {

    private val realm: Realm = Realm.getDefaultInstance()

    fun getLogs(): ArrayList<EventLoggerModel> {
        val resultLogs = ArrayList<EventLoggerModel>()
        realm.beginTransaction()
        val logs = realm.where(LoggerRealmObject::class.java).findAll()
        realm.commitTransaction()
        for (log in logs) {
            val eventLoggerModel = EventLoggerModel.EventLoggerBuilder()
                .setIp(log.ip)
                .setAppId(log.app_id)
                .setAppName(log.app_name)
                .setEventName(log.event_name)
                .setUserId(log.user_id)
                .setUserType(log.user_type)
                .setDeviceModel(log.device_model)
                .setDeviceId(log.device_id)
                .setLogTime(log.log_time)
                .setEventData(log.event_data)
                .setAppVersion(log.app_version)
                .setLat(log.lat)
                .setLng(log.lng)
                .build()
            resultLogs.add(eventLoggerModel)
        }
        return resultLogs
    }

    fun logEvent(eventLoggerModel: EventLoggerModel) {
        realm.executeTransactionAsync({
            val eventId = UUID.randomUUID().toString()
            val event = it.createObject(LoggerRealmObject::class.java, eventId)
            event.ip = eventLoggerModel.ip
            event.app_id = eventLoggerModel.appId
            event.app_name = eventLoggerModel.appName
            event.event_name = eventLoggerModel.eventName
            event.user_id = eventLoggerModel.userId
            event.user_type = eventLoggerModel.userType
            event.device_model = eventLoggerModel.deviceModel
            event.device_id = eventLoggerModel.deviceId
            event.event_data = eventLoggerModel.eventData
            event.app_version = eventLoggerModel.appVersion
            event.lat = eventLoggerModel.lat
            event.lng = eventLoggerModel.lng
        }, {
            // success
        }, {
            // error
        })
    }

    fun deleteFromDatabase() {
        realm.beginTransaction()
        val results = realm.where(LoggerRealmObject::class.java).limit(LOGS_LIMIT).findAll()
        results.deleteAllFromRealm()
        realm.commitTransaction()
    }


}