# Bitflip Utils - A collection of utilities for FTC

-------- 

## Quickstart
Add the following to your `TeamCode` `build.gradle`:
### `repositories` block
```gradle
maven { url = "https://maven.bitflip.club/releases" }
```
### `dependencies` block
```gradle
implementation ("club.bitflip:utils:1.0.2")
```
**NOTE**: if you are using the SlothLoad fork of panels, replace the above line for the `dependencies` block with this:
```gradle
implementation ("club.bitflip:utils:1.0.2") {
    exclude group: 'com.bylazar'
}
```

---------

## Feature Summary
- `Utils.kt` provides a few PedroPathing path builder helper functions, as well as angle calculation functions.
- `PIDController` is a PID Controller that allows you to customize basically any parameter.
- `Component` is an interface which has the `start()` and `loop()` functions, allowing you to group many small components together and run them all at once.
    - `LoopTimeComponent` implements `Component` and allows you to easily print your loop times in ms and hz.
 - `TelemetryImplUpstreamSubmission` is an optimized telemetry class (NOT MY OWN WORK).
 - `OpModeManager` is a translation of a java class of the same name from [Marrow FTC](https://github.com/Skeleton-Army/Marrow/blob/main/core/src/main/java/com/skeletonarmy/marrow/OpModeManager.java) that simplifies usage in Kotlin.
 - Hardware classes that simplify initialization and provide both read and write caching as well as motor slew rate limiting.
    - `MotorEx`
    - `ServoEx`
    - `CRServoEx`
