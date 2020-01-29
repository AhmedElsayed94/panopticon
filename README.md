# Panopticon
Event Logger - cache events data and send it to your own back-end end point

# Description
Simply this sdk to log your events localy and sends them as a bulk to your back-end end point

# Implementation

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
  
Step 2. Add the dependency

```
	dependencies {
	        implementation 'com.github.AhmedElsayed94:panopticon:Tag'
	}
  ```
  
Step 3. 

this sdk is dependent on Realm so You must provide an Android context to initialize Realm in onCreate on an application subclass:

```
public class MyApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Realm.init(this);
  }
}
```
you must add it to the app’s AndroidManifest.xml:

```
<application
  android:name=".MyApplication"
  ...
/>

```
# How To Use

first config your event logger object in your base activity/fragemnt .. 

you must give it 

base_url -> which is you base back-end end point

auth_key -> which will is a key we will send it as a header in the api call , for example token 

        val eventLogger = EventLogger(
            "http://test.com/",
            "ACES125A"
        )

you can also set your cache logs limit by setting its value after creating your object otherwise it will be 20 logs as default value and will call the api after the logs cache reach 20 logs 

        eventLogger.setLogsLimit(3)
        
you can send your event by using this model

```
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
            .setLng("31.156151")
            .setLat("28.115151")
            .build()

        eventLogger.logEvent(eventLoggerModel)

```
this will save your log event in the database by sending the event to logEvent method

whenever you want to fire the events buld to your endpoint just call the following method

        eventLogger.fireEventsToServer()
        
Note :  

eventLogger.fireEventsToServer() will only triggered when it reach the log_limit that you put in your config.

# API

```
@POST("event-log/")

```
Takes "key" in header and the following json in body

```
{
  "logs":[
    {
      "app_id":"CHSZKJ",
      "app_name":"Panopticon",
      "app_version":"1.0.0",
      "device_id":"AHJXKKK55",
      "device_model":"A10",
      "event_data":"{
        test,
        test
      }",
      "event_name":"main_screen",
      "ip":"192.168.1.1",
      "lat":"",
      "lng":"",
      "log_time":"",
      "user_id":13,
      "user_type":"Super User"
    },
    {
      "app_id":"CHSZKJ",
      "app_name":"Panopticon",
      "app_version":"1.0.0",
      "device_id":"AHJXKKK55",
      "device_model":"A10",
      "event_data":"{
        test,
        test
      }",
      "event_name":"main_screen",
      "ip":"192.168.1.1",
      "lat":"",
      "lng":"",
      "log_time":"",
      "user_id":13,
      "user_type":"Super User"
    },
    {
      "app_id":"CHSZKJ",
      "app_name":"Panopticon",
      "app_version":"1.0.0",
      "device_id":"AHJXKKK55",
      "device_model":"A10",
      "event_data":"{
        test,
        test
      }",
      "event_name":"main_screen",
      "ip":"192.168.1.1",
      "lat":"",
      "lng":"",
      "log_time":"",
      "user_id":13,
      "user_type":"Super User"
    },
    {
      "app_id":"CHSZKJ",
      "app_name":"Panopticon",
      "app_version":"1.0.0",
      "device_id":"AHJXKKK55",
      "device_model":"A10",
      "event_data":"{
        test,
        test
      }",
      "event_name":"main_screen",
      "ip":"192.168.1.1",
      "lat":"",
      "lng":"",
      "log_time":"",
      "user_id":13,
      "user_type":"Super User"
    }
  ]
}
```

# Thanks





  
