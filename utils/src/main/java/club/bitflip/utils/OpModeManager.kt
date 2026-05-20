package club.bitflip.utils

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.OpModeManagerImpl
import com.qualcomm.robotcore.eventloop.opmode.OpModeManagerNotifier
import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.robot.RobotState
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.robotcore.internal.system.AppUtil

/**
 * @author skeleton army ftc wrote the original java file. Bitflip ftc translated it to kotlin
 */
object OpModeManager {
    /**
     * Retrieves the internal OpModeManagerImpl instance.
     *
     * @return The active OpModeManagerImpl instance
     * @throws IllegalStateException if the activity or the OpModeManagerImpl are not yet available.
     */
    @JvmStatic
    val manager: OpModeManagerImpl
        get() {
            val activity = AppUtil.getInstance().activity
                ?: throw IllegalStateException("OpModeManager called before activity is available. Ensure this runs after the robot is initialized.")

            val internalManager = OpModeManagerImpl.getOpModeManagerOfActivity(activity)
                ?: throw IllegalStateException("OpModeManagerImpl is null. The OpMode system may not be fully initialized.")
            
            return internalManager
        }

    /**
     * Retrieves the currently active OpMode.
     *
     * @return The active OpMode, or null if no OpMode is running.
     */
    @JvmStatic
    val activeOpMode: OpMode
        get() = manager.activeOpMode

    /**
     * Retrieves the name of the currently active OpMode.
     *
     * @return The name of the active OpMode.
     */
    @JvmStatic
    val activeOpModeName: String
        get() = manager.activeOpModeName

    /**
     * Retrieves the current state of the robot controller.
     *
     * @return The current RobotState enum (e.g., INIT, RUNNING).
     */
    @JvmStatic
    val robotState: RobotState
        get() = manager.robotState

    /**
     * Retrieves the current HardwareMap.
     *
     * @return The active HardwareMap object.
     */
    @JvmStatic
    val hardwareMap: HardwareMap
        get() = manager.hardwareMap

    /**
     * Retrieves the current Telemetry.
     *
     * @return The active Telemetry object.
     */
    @JvmStatic
    val telemetry: Telemetry
        get() = activeOpMode.telemetry

    /**
     * Registers a listener to receive notifications when the OpMode lifecycle changes (e.g., init, start, stop).
     *
     * @param listener The listener implementing OpModeManagerNotifier.Notifications
     * @return The active OpMode at the time of registration, or null
     */
    @JvmStatic
    fun registerListener(listener: OpModeManagerNotifier.Notifications): OpMode {
        val opMode = manager.registerListener(listener)
            ?: throw IllegalStateException("OpMode is not initialized!")
        return opMode
    }

    /**
     * Unregisters a listener previously registered for OpMode lifecycle notifications.
     *
     * @param listener The listener to remove
     */
    @JvmStatic
    fun unregisterListener(listener: OpModeManagerNotifier.Notifications) {
        manager.unregisterListener(listener)
    }
}
