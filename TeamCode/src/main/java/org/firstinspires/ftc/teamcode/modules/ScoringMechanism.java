package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.hardware.ConditionalHardwareDevice;
import org.firstinspires.ftc.teamcode.modules.core.Module;

/**
 * The Scoring Mechanism
 */
public class ScoringMechanism extends Module {
    public static final String MOTOR_NAME = "Scoring Motor";
    private final ConditionalHardwareDevice<DcMotor> motor;

    /**
     * Initializes the module and registers it with the specified OpMode.  This is where references to any hardware
     * devices used by the module are loaded.
     *
     * @param registrar The OpMode initializing the module
     */
    public ScoringMechanism(OpMode registrar) {
        super(registrar);
        motor = ConditionalHardwareDevice.tryGetHardwareDevice(parent.hardwareMap, DcMotor.class, MOTOR_NAME);
    }


    /**
     * Logs data about the module to telemetry
     */
    @Override
    public void log() {

    }
}
