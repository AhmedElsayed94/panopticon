package  com.example.panopticon_event_logger.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class LoggerRealmObject(
    @PrimaryKey
    var id: String = "",
    var ip: String = "",
    var app_id: String = "",
    var app_name: String = "",
    var event_name: String = "",
    var user_id: Int = 0,
    var user_type: String = "",
    var device_model: String = "",
    var device_id: String = "",
    var lat: String = "",
    var lng: String = "",
    var log_time: String = "",
    var event_data: String = "",
    var app_version: String = ""

) : RealmObject()