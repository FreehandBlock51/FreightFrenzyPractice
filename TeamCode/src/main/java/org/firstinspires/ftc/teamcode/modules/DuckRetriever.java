package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.hardware.ConditionalHardwareDevice;
import org.firstinspires.ftc.teamcode.modules.core.Module;

/**
 * The module that retrieves ducks from the disk they are initially placed on
 */
public class DuckRetriever extends Module {
    /**
     * The motor that spins the disk to retrieve the ducks
     */
    private final ConditionalHardwareDevice<DcMotor> spinnerMotor;

    /**
     * The name of the motor that spins the disk to retrieve the duck
     */
    public static final String SPINNER_MOTOR_NAME = "Spinner";

    // Calculations for how far we need to spin the motor
    public static final double DUCK_DISK_RADIUS = 1;
    public static final double SPINNER_RADIUS = 1;
    public static final double DUCK_DISK_CIRCUMFERENCE = DUCK_DISK_RADIUS * 2 * Math.PI;
    public static final double SPINNER_CIRCUMFERENCE = SPINNER_RADIUS * 2 * Math.PI;
    public static final double TARGET_ROTATION_MULTIPLIER = SPINNER_CIRCUMFERENCE / DUCK_DISK_CIRCUMFERENCE;
    public static final double ENCODER_RESOLUTION = 3;
    public static final double TARGET_POSITION_OFFSET = ENCODER_RESOLUTION * TARGET_ROTATION_MULTIPLIER;

    public static final double SPINNER_POWER_WHEN_ROTATING = 0.5;

    public static final double DEFAULT_TIMEOUT_SECONDS = 10;

    /**
     * Initializes the module and registers it with the specified OpMode.  This is where references to any hardware
     * devices used by the module are loaded.
     *
     * @param registrar The OpMode initializing the module
     */
    public DuckRetriever(OpMode registrar) {
        super(registrar);

        spinnerMotor = ConditionalHardwareDevice.tryGetHardwareDevice(registrar.hardwareMap, DcMotor.class, SPINNER_MOTOR_NAME);
    }

    public void retrieveDuck(double timeoutSeconds) {
        spinnerMotor.runIfAvailable(motor -> {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motor.setPower(SPINNER_POWER_WHEN_ROTATING);
            final ElapsedTime elapsedTime = new ElapsedTime();
            while (motor.getCurrentPosition() < TARGET_POSITION_OFFSET & elapsedTime.seconds() < timeoutSeconds) {
                Thread.yield();
            }
            motor.setPower(0.0);
        });
    }
    public void retrieveDuck() {
        retrieveDuck(DEFAULT_TIMEOUT_SECONDS);
    }

    /**
     * Logs data about the module to telemetry
     */
    @Override
    public void log() {

    }
}
