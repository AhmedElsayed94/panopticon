package com.example.panopticon_event_logger.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class EventLoggerModel {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("app_id")
    @Expose
    private String appId ;
    @SerializedName("app_name")
    @Expose
    private String appName;
    @SerializedName("event_name")
    @Expose
    private String eventName;
    @SerializedName("user_id")
    @Expose
    private int userId ;
    @SerializedName("user_type")
    @Expose
    private String userType ;
    @SerializedName("device_model")
    @Expose
    private String deviceModel;
    @SerializedName("device_id")
    @Expose
    private String deviceId ;
    @SerializedName("log_time")
    @Expose
    private String logTime ;
    @SerializedName("event_data")
    @Expose
    private HashMap<String, String> eventData ;
    @SerializedName("app_version")
    @Expose
    private String appVersion;

    public String getIp() {
        return ip;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppName() {
        return appName;
    }

    public String getEventName() {
        return eventName;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getLogTime() {
        return logTime;
    }

    public HashMap<String, String> getEventData() {
        return eventData;
    }

    public String getAppVersion() {
        return appVersion;
    }

    private EventLoggerModel(EventLoggerBuilder builder) {
        this.ip=builder.ip;
        this.appId=builder.appId;
        this.appName=builder.appName;
        this.eventName=builder.eventName;
        this.userId=builder.userId;
        this.userType=builder.userType;
        this.deviceModel=builder.deviceModel;
        this.deviceId=builder.deviceId;
        this.logTime=builder.logTime;
        this.eventData=builder.eventData;
        this.appVersion=builder.appVersion;
    }

    //Builder Class

    public static class EventLoggerBuilder{

        public EventLoggerBuilder() {
        }

        private String ip;
        private String appId ;
        private String appName;
        private String eventName;
        private int userId ;
        private String userType ;
        private String deviceModel ;
        private String deviceId ;
        private String logTime ;
        private HashMap<String, String> eventData = new HashMap<String, String>();
        private String appVersion ;


        public EventLoggerBuilder setIp(String ip) {
            this.ip = ip;
            return this ;
        }

        public EventLoggerBuilder setAppId(String appId) {
            this.appId = appId;
            return this ;
        }

        public EventLoggerBuilder setAppName(String appName) {
            this.appName = appName;
            return this ;
        }

        public EventLoggerBuilder setEventName(String eventName) {
            this.eventName = eventName;
            return this ;
        }

        public EventLoggerBuilder setUserId(int userId) {
            this.userId = userId;
            return this ;
        }

        public EventLoggerBuilder setUserType(String userType) {
            this.userType = userType;
            return this ;
        }

        public EventLoggerBuilder setDeviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
            return this ;
        }

        public EventLoggerBuilder setDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this ;
        }

        public EventLoggerBuilder setLogTime(String logTime) {
            this.logTime = logTime;
            return this ;
        }

        public EventLoggerBuilder setEventData(HashMap<String, String> eventData) {
            this.eventData = eventData;
            return this ;
        }

        public EventLoggerBuilder setAppVersion(String appVersion) {
            this.appVersion = appVersion;
            return this ;
        }

        public EventLoggerModel build(){
            return new EventLoggerModel(this);
        }
    }


    @NotNull
    @Override
    public String toString() {
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
                '}';
    }
}
