package org.firstinspires.ftc.teamcode.hardware.test;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DcMotorTest {
    private final DcMotor motor;

    public DcMotorTest(DcMotor motor) {
        this.motor = motor;
    }

    public DcMotor getMotor() {
        return motor;
    }

    public void assertMotorPowerIs(double expectedPower, double marginOfError) {
        if (Math.abs(motor.getPower() - expectedPower) > marginOfError) {
            throw new AssertionError("Motor power was not within range of expected " + expectedPower);
        }
    }
}
