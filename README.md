# Running the app (v 0.1)

* Install Android Studio
* git clone this repository
* git checkout the sandbox branch
* Run the app
* You wil need your user name and password for Tesla to login the first time. Once logged in, the app will save the "token" in its settings on the simulator
* Launch the app once more and now you can use it

# API Guide
[Tesla API Behavior](./API%20Guide/main.md)

## Clearing Token in App

The Android app stores the token in app settings after you authenticate for the first time. This is done so you do not have to login with user name and password all the time.

Just in case you wanted to clear that token and generate a new one, you should:
* Put a breakpoint anywhere in the app and start the debugger
* Run this code fragment (or evaluate expression): `AppSettings.clear()`
* Restart the app. This will now prompt you to login again

## Contributors:
* Ali Badereddin @alibad
* Ryan Moore @rmooreID