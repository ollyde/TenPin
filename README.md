# TenPin
TenPin bowling with LibGDX Example using Scene2D.

##Some notes
This was actually a little learning exercise for myself, as I though ‘why not benefit myself from this’. So I decided to use am attachment framework I’ve never used before ‘Scene2D’.
This project works on everything natively. Browsers, Android, Windows, Mac, iOS (iPad,iPhone,Apple watch) - Also uses the GPU on all these devices for maximum performance.

You find the main code within the “core” folder, this contains my code (Although I have setup code else where it doesn’t concern you guys).
Everything within com.oliverdixon.app I've created for this demo.

Overlay of code.
MainStage is where the main setup for UI is happening.
GameController is where the game logic resides.

Importing the project.
- Simply open with Android studio and Gradle will fetch all the libraries, first build will take awhile while it downloads.

##Desktop
If you want to run this on desktop 
- Click Run/Debug Configurations
- Add new “Application”.
- Choose a name like “Desktop"
- Set the main class as “DesktopLauncher”.
- Working directory is “android/assets/“.
- Classpath is Desktop.

##Android
Standard Android Studio setup, then just compile and it should work on any android device.

##iOS (iPhone or iPad)
- In the console/terminal in Android studio you can type ''./gradlew tasks” for a list of web options and iOS options.
- The easiest solution for iPhones is ‘’./gradlew launchIOSDevice” or ‘’./gradlew launchIPhoneSimulator”.
- You might want to change the simulator to iPhone 6.
- The first build takes a few minutes as RoboVM builds binaries but after that it only takes a few seconds.

Any questions just ask!
