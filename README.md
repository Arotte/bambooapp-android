# Bamboo 

This repository holds the source code for the Bamboo Mobile App. The app is built for android using Java and acts as a proof of concept before building the production version in Kotlin & Swift for Android & iOS respectively.

## What is Bamboo?
The usage of smartphones has been linked to mental heath problems a long time ago. Particularly, research has shown that the more the youth uses their smartphones, the more they are at risk of mental distress, self-injuries and suicide. And that is where our app comes into play. We aim to develop an app that would keep track of the usage of different apps and correlate it to the emotional state of the user. Based on this data we could inform the users about their "ideal app-usage" which would aim at maximising their very own wellbeing.

Of course, we know everyone is different. So, we would have an in-app personalisation features allowing the users the set their goal - whether they are looking to find out which apps contribute to their anxiety, make them feel depressed, or make them dislike their bodies, we have them covered.

Last but not least, our app would be easily accessible and could be recommended to vulnerable young people in order to help them manage their app use wisely and eliminate the harmful effects the use of some apps can have. We believe this would be especially useful in the time people are waiting to access therapists or even when they are saving up to be able to afford therapy sessions - because one never knows, maybe simply finding out that the way we use our phone is what stops us from feeling good.

## How would we do this?
* Native Android application with Kotlin and JetPack Compose.
* Native iOS application with Swift.
* A machine learning pipeline. Production models are deployed to a set of AWS/GCP servers with load balancing running on JS Node.js and PSQL. A set of (re)training servers living on AWS/GCP running on Python Flask and PSQL.
* A serverless backend living on AWS/GCP in Node.js and PSQL database on AWS Aurora.



 
Folder Structure
----------------

The app itself is inside the `app/src/main/` folder of the project. The `java/` folder contains all the logic and “back-end” code of the mobile application. The `res/` folder contains all the “front-end” code of the mobile application: XML files describing how the UI should look. All of the XML files for all of our app screens are inside the `res/layout/` folder.

Running the app
---------------

### From APK

We have provided a pre-built APK that should be installable and runnable on any Android smartphone. The operating system of the device used must be relatively new. If not, some UI elements might not render correctly.

The APK is accessible under the `/prebuilt/apk/` folder and is called `Bamboo-app.apk`. Upon downloading the APK to a suitable device, tapping on it should automatically start the installation process.

### Inside an emulator

The app can also be run inside an Android emulator. Virtually any Android emulator can be used for this task, however the most tested approach is using Android Studio's built-in emulator feature.

The steps to run Bamboo in Android Studio's emulator are the following:
   1. Click on "Device Manager" on the right sidebar.
   2. Click on "Create Device".
   3. Select "Phone" as a category, then select a phone from the list. Any "Pixel" device should do, we used "Pixel 4".
   4. Click on "Next".
   5. Select either "S" or "R" from the list that appears. If you didn't do this process before, Android Studio will start downloading the selected system image.
   6. Click on "Next".
   7. Click on "Finish".

After these steps your virtual device should be up a running. If not, follow these steps:
   1. Click on "Device Manager" on the right sidebar.
   2. Click on the appearing green launch icon of your previously created device.

Once the virtual device is up and running, you should be able to start the Bamboo application by clicking the green start button on the top right corner of Android Studio.

### On a physical Android device

If you don't want to install Bamboo on your physical device from the provided APK, you can install, start and debug the application directly thourgh Android Studio.

**Enabling developer options**

If you don't have developer options enabled on your device, follow these steps to enable it:
   1. Go to Settings > About Phone.
   2. Tap Software Info > Build Number.
   3. Tap Build Number seven times. After the first few taps, you should see the steps descreasing. Continue tapping until you get a notification that developer options are now enabled.

**Enabling USB debugging**

Once the developer options have been enabled, you can enable USB debugging by:
   1. Go to Settings > Developer options.
   2. Enable USB debugging.

**Running Bamboo**

If you have developer options and USB debugging enabled on your Android device, then running the app is as simple as:
   1. Connect the device to your computer with a (USB) cable.
   2. Android Studio should automatically recognize it. Check the "Device Manager" by navigating to the "Physical" tab.
   3. Run the application by selecting your device from the drop-down list on the top righ corner, then hitting the play button.




Exporting an installable APK
------------

To export an installable API of the app, you can use the Android Studio's built-in `APK` exporter. Simply navigate to Build > Build APK(s) > Build APK. Android Studio will generate the API in the `app\build\intermediates\apk\debug` folder.



Contributing
----------------

To start contributing to the project, follow these steps.

### Important git policies

Following the policies and conventions of this project are vital for producing quality software. 


*All developers must:*
* Follow the semantic commit message convention. More on this: https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716.
* Commit as frequently as possible. Do not produce commits that are hunders or thousands of changed lines of code long.
* Use feature branches for your tasks. Do not commit directly to `develop`.
* When finished with a task, push the feature branch to GitHub, open a PR, and wait for reviews. When you get the green light, merge the PR and delete your feature branch both on GitHub and locally.
* If you encounter bugs or have a feature idea, open a new GitHub Issue.