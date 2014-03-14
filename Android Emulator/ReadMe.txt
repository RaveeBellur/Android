This project demonstrates the following stages to test the web applications on Android: 

1. Environment setup required to test on Android platform. 
2. Develop skeleton test framework on Eclipse using Selenium WebDriver/TestNG. 
3. Run the tests on Android emulator.

Software required to execute this test: Eclipse, Android SDK, TestNG, selenium-server-standalone-2.37.0.jar.

Note:
-----
Before running the tests make sure the below steps are followed.


Description:
------------
Mobile applications are getting prominent with the increasing usage of Smartphones and tablets. The world talks about Android, iPhone, iPad. Hence it is necessary to develop and test applications that run on these platforms. Selenium supports testing web applications in mobile web browsers.

We can run automated tests on a Simulator/Emulator or on a real device using iOS and Android drivers. Here we will see an example to configure and use Selenium WebDriver to test an application on Android.

The AndroidDriver allows running the automated tests and ensuring your web application works correctly on an Android browser for various versions of Android. The AndroidDriver supports user interactions such as taps, flicks, and scrolls.
The AndroidDriver requires the Android server APK to be installed on the emulator or device. After the Android server APK is set up on the emulator or device, the test code connects to the Android server APK to execute the tests similar to a client/server application.

The Android emulator enables you to test your applications without using an actual Android device. The Android emulator also has the capability of simulating different versions of Android.

Setting up the Android emulator for Selenium on windows 7 OS
-------------------------------------------------------------
I. Installation of Android SDK
-------------------------------
1) Install the SDK starter package http://developer.android.com/sdk/index.html
2) Click on ‘SDK Manager.exe’ which will launch ‘Android SDK Manager’. By default “Installed packages” will be highlighted. Choose the Android version you want to install and click on Install packages.
3) Click on ‘AVD Manager.exe’ which will launch ‘Android Virtual Device Manager’. Create a new Virtual device by clicking on ‘New’.
		 a. Specify any name for your device. 
		 b. Select the Android version in the ‘Target’ field. In this example, Android 4.2.2 - API Level 17 is specified. 
		 c. Specify the Size in the SD Card field. For our example 512 MiB is specified. 
		 d. Keep the rest of the values as default, unless you want to something specific. 
4) Click on the Create AVD button. 
5) To launch the newly created AVD, select the newly created AVD in the AVD Manager and click on ‘Start’. 
6) The Launch Options dialog box will be displayed. Keep all the options as default and click on the Launch button to start the AVD. This launches the Android emulator.

II. Install the WebDriver APK
------------------------------ 
1) Navigate to the platform-tools directory in the sdk directory.
2) Run the following command to get the serial ID of the device or emulator: 
			adb devices 
   The serial ID displayed will be emulator-5554.
3) Download the Android server APK from http://code.google.com/p/selenium/downloads/list
4) Copy the Android server APK file to the platform-tools directory in the sdk directory.
5) Install the Android server APK on the emulator by using the following command: 
		adb -s emulator-5554 -e install -r <android-server.apk>
	Wait for the Success message to appear.	
6) After installing the Android server APK, launch the WebDriver application by using the following command:
		adb -s emulator-5554 shell am start -a android.intent.action.MAIN -n org.openqa.selenium.android.app/.MainActivity

	The emulator will start the WebDriver application. A WebDriver Ready message will be displayed on the emulator screen. (We can also launch the WebDriver application by clicking on the WebDriver Application icon in the
	Application menu on an Android device or emulator. If done this way, above step is not necessary).

7) Finally, we need to set up the port forwarding in order to forward the traffic from the host machine to the emulator by using the following command: 
		adb forward tcp:8080 tcp:8080
8) The Android server will be available at http://localhost:8080/wd/hub from the host machine. Now the emulator is ready to run the tests. Opening this URL in Firefox will show up a blank page on success.
9) Confirm the following settings on your emulator: Settings -> Developer Options -> Check "USB debugging", "Stay Awake" and "Allow mock locations".
10)Launch the WebDriver application installed on the device/emulator.