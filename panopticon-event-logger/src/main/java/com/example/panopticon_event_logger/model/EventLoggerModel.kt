package com.example.panopticon_event_logger.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class EventLoggerModel private constructor(builder: EventLoggerBuilder) {
    @SerializedName("ip")
    @Expose
    val ip: String?
    @SerializedName("app_id")
    @Expose
    val appId: String?
    @SerializedName("app_name")
    @Expose
    val appName: String?
    @SerializedName("event_name")
    @Expose
    val eventName: String?
    @SerializedName("user_id")
    @Expose
    val userId: Int
    @SerializedName("user_type")
    @Expose
    val userType: String?
    @SerializedName("device_model")
    @Expose
    val deviceModel: String?
    @SerializedName("device_id")
    @Expose
    val deviceId: String?
    @SerializedName("log_time")
    @Expose
    val logTime: String?
    @SerializedName("event_data")
    @Expose
    val eventData: HashMap<String, String>
    @SerializedName("app_version")
    @Expose
    val appVersion: String?

    //Builder Class
    class EventLoggerBuilder {
        var ip: String? = null
        var appId: String? = null
        var appName: String? = null
        var eventName: String? = null
        var userId = 0
        var userType: String? = null
        var deviceModel: String? = null
        var deviceId: String? = null
        var logTime: String? = null
        var eventData = HashMap<String, String>()
        var appVersion: String? = null

        fun setIp(ip: String?): EventLoggerBuilder {
            this.ip = ip
            return this
        }

        fun setAppId(appId: String?): EventLoggerBuilder {
            this.appId = appId
            return this
        }

        fun setAppName(appName: String?): EventLoggerBuilder {
            this.appName = appName
            return this
        }

        fun setEventName(eventName: String?): EventLoggerBuilder {
            this.eventName = eventName
            return this
        }

        fun setUserId(userId: Int): EventLoggerBuilder {
            this.userId = userId
            return this
        }

        fun setUserType(userType: String?): EventLoggerBuilder {
            this.userType = userType
            return this
        }

        fun setDeviceModel(deviceModel: String?): EventLoggerBuilder {
            this.deviceModel = deviceModel
            return this
        }

        fun setDeviceId(deviceId: String?): EventLoggerBuilder {
            this.deviceId = deviceId
            return this
        }

        fun setLogTime(logTime: String?): EventLoggerBuilder {
            this.logTime = logTime
            return this
        }

        fun setEventData(eventData: HashMap<String, String>): EventLoggerBuilder {
            this.eventData = eventData
            return this
        }

        fun setAppVersion(appVersion: String?): EventLoggerBuilder {
            this.appVersion = appVersion
            return this
        }

        fun build(): EventLoggerModel {
            return EventLoggerModel(this)
        }
    }

    override fun toString(): String {
        return "EventLoggerModel{" +
                "ip='" + ip + '\'' +
                ", appId='" + appId + '\'' +
                ", appName='" + appName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", userId=" + userId +
                ", userType='" + userType + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", logTime='" + logTime + '\'' +
                ", eventData=" + eventData +
                ", appVersion='" + appVersion + '\'' +
                '}'
    }

    init {
        ip = builder.ip
        appId = builder.appId
        appName = builder.appName
        eventName = builder.eventName
        userId = builder.userId
        userType = builder.userType
        deviceModel = builder.deviceModel
        deviceId = builder.deviceId
        logTime = builder.logTime
        eventData = builder.eventData
        appVersion = builder.appVersion
    }
}