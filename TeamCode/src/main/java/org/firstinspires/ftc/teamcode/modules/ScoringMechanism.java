package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.hardware.ConditionalHardwareDevice;
import org.firstinspires.ftc.teamcode.modules.core.Module;

/**
 * The Scoring Mechanism
 */
public class ScoringMechanism extends Module {
    public static final String SLIDE_MOTOR_NAME = "Slide Motor";
    private final ConditionalHardwareDevice<DcMotor> slideMotor;

    public static final String ARM_SERVO_NAME = "Arm Servo";
    private final ConditionalHardwareDevice<Servo> armServo;

    public static final String FLAP_SERVO_NAME = "Flap Servo";
    private final ConditionalHardwareDevice<Servo> flapServo;

    /**
     * Initializes the module and registers it with the specified OpMode.  This is where references to any hardware
     * devices used by the module are loaded.
     *
     * @param registrar The OpMode initializing the module
     */
    public ScoringMechanism(OpMode registrar) {
        super(registrar);
        slideMotor = ConditionalHardwareDevice.tryGetHardwareDevice(parent.hardwareMap, DcMotor.class, SLIDE_MOTOR_NAME);
        armServo = ConditionalHardwareDevice.tryGetHardwareDevice(parent.hardwareMap, Servo.class, ARM_SERVO_NAME);
        flapServo = ConditionalHardwareDevice.tryGetHardwareDevice(parent.hardwareMap, Servo.class, FLAP_SERVO_NAME);
    }



    /**
     * Logs data about the module to telemetry
     */
    @Override
    public void log() {

    }
}
