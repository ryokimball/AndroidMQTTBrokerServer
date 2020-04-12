# MQTT Broker for Android

Nothing special here, yet. I tried getting [Moquette](https://moquette-io.github.io/moquette/) working but the [two lines of instruction](https://moquette-io.github.io/moquette/documentation.html#_embedding_inside_android):
-   add the permission `WRITE_EXTERNAL_STORAGE` in the Manifest.mf
-   change in the gradle file the `targetSdkVersion` from 26 to 22

failed to change the outcome of write error:
> Can't create temp file for subscriptions storage

This is not an uncommon error, but if those two changes didn't fix it, I don't know what to do. ~~So I'm probably going to try [Paho](https://github.com/eclipse/paho.mqtt.android) next~~ ("The Paho Android Service is an MQTT client library" --misread that before). 

The goal of this project is simple. I have an older Android device (Galaxy S5 running 6.0.1) which will be the main interface for my IoT things, and will always be on anyway, so it might as well be the server, too. 

Note that I am handy with coding in general but no real experience with IoT/MQTT and very light experience with Android, much less Android, so don't expect miracles from me. 
