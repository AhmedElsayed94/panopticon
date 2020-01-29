package com.panopticon.panopticon_event_logger.base

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

class Panopticon(val context : Context) {
    init {
        // Initialize Realm. Should only be done once when the application starts.
        Realm.init(context)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
    }
}