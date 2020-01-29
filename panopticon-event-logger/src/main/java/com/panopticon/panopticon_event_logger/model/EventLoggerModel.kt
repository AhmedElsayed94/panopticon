package com.panopticon.panopticon_event_logger.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EventLoggerModel private constructor(builder: EventLoggerBuilder) {

    @SerializedName("ip")
    @Expose
    var ip: String = ""
    @SerializedName("app_id")
    @Expose
    var appId: String = ""
    @SerializedName("app_name")
    @Expose
    var appName: String = ""
    @SerializedName("event_name")
    @Expose
    var eventName: String = ""
    @SerializedName("user_id")
    @Expose
    var userId: Int
    @SerializedName("user_type")
    @Expose
    var userType: String = ""
    @SerializedName("device_model")
    @Expose
    var deviceModel: String = ""
    @SerializedName("device_id")
    @Expose
    var deviceId: String = ""
    @SerializedName("log_time")
    @Expose
    var logTime: String = ""
    @SerializedName("event_data")
    @Expose
    var eventData: String = ""
    @SerializedName("app_version")
    @Expose
    var appVersion: String = ""
    @SerializedName("lat")
    @Expose
    var lat: String = ""
    @SerializedName("lng")
    @Expose
    var lng : String = ""

    //Builder Class
    class EventLoggerBuilder {
        var ip: String = ""
        var appId: String = ""
        var appName: String = ""
        var eventName: String = ""
        var userId = 0
        var userType: String = ""
        var deviceModel: String = ""
        var deviceId: String = ""
        var logTime: String = ""
        var eventData : String = ""
        var appVersion: String = ""
        var lat : String = ""
        var lng: String = ""

        fun setIp(ip: String): EventLoggerBuilder {
            this.ip = ip
            return this
        }

        fun setAppId(appId: String): EventLoggerBuilder {
            this.appId = appId
            return this
        }

        fun setAppName(appName: String): EventLoggerBuilder {
            this.appName = appName
            return this
        }

        fun setEventName(eventName: String): EventLoggerBuilder {
            this.eventName = eventName
            return this
        }

        fun setUserId(userId: Int): EventLoggerBuilder {
            this.userId = userId
            return this
        }

        fun setUserType(userType: String): EventLoggerBuilder {
            this.userType = userType
            return this
        }

        fun setDeviceModel(deviceModel: String): EventLoggerBuilder {
            this.deviceModel = deviceModel
            return this
        }

        fun setDeviceId(deviceId: String): EventLoggerBuilder {
            this.deviceId = deviceId
            return this
        }

        fun setLogTime(logTime: String): EventLoggerBuilder {
            this.logTime = logTime
            return this
        }

        fun setEventData(eventData: String): EventLoggerBuilder {
            this.eventData = eventData
            return this
        }

        fun setAppVersion(appVersion: String): EventLoggerBuilder {
            this.appVersion = appVersion
            return this
        }

        fun setLat(lat: String): EventLoggerBuilder {
            this.lat = lat
            return this
        }
        fun setLng(lng: String): EventLoggerBuilder {
            this.lng = lng
            return this
        }

        fun build(): EventLoggerModel {
            return EventLoggerModel(this)
        }
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
        lat = builder.lat
        lng = builder.lng
    }

    override fun toString(): String {
        return "EventLoggerModel(ip=$ip, appId=$appId, appName=$appName, eventName=$eventName, userId=$userId, userType=$userType, deviceModel=$deviceModel, deviceId=$deviceId, logTime=$logTime, eventData=$eventData, appVersion=$appVersion, lat=$lat, lng=$lng)"
    }


}
