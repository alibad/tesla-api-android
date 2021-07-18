# The Tesla API Sandbox App

## Why we did it?
To learn how to control our car from a smartphone, we needed to dig deep and an app was a great way to surface the functionality we needed, especially that a mobile device is accessible anywhere.

We’ve also noticed a good amount of Tesla apps showing up in Apple and Google app stores, which meant a lot of people are interested in building apps for Tesla. That got us even more excited to finish building the app, so others would benefit from the work we are doing and have less friction turning their ideas into reality.

## Why should you care?
We think this app is the easiest way to learn what the Tesla APIs does. Install it on an Android device, sit in the car, and start playing with all the different APIs available. This should enable you to quickly learn and speed up your process, going from idea to viability in just a few minutes with API exploration within the app.

We have also created documentation, building up on the work done by [timdor](https://github.com/timdorr/tesla-api), including all the curl commands for easy testing on Windows or Mac devices.

This repository could be easily forked to quickly create a Tesla integrated app. Logging in, log out, retry on wakeup, observe all state values, and trigger any of the commands.

We have deliberately decided to focus on an Android app first for two reasons: 
* We want to see how many folks are interested in building mobile applications for Tesla cars.
* We want to create an open source community for folks to collaborate. To help reduce the friction for making our smart cars smarter and to help lower the barrier to entry, an Android app was a good place to start.

| Car State  | Commands | Parameters |
| ------------- | ------------- | ------------- |
| ![Car Info](https://user-images.githubusercontent.com/6937273/126083133-ddce2043-bdc5-4ca4-804e-ddb513099156.png) | ![Commands you can give your car](https://user-images.githubusercontent.com/6937273/126083135-11e3c321-44ba-4f67-9114-f1757397c3f4.png) | ![Command behavior : parameters](https://user-images.githubusercontent.com/6937273/126083136-c3030e76-a58f-4e86-934e-1a974e28fe62.png) |


## More Details
[Read more and discuss with the contributors at cTrl Blog](https://www.ctrl-iot.com/post/the-tesla-api-sandbox-app)

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
