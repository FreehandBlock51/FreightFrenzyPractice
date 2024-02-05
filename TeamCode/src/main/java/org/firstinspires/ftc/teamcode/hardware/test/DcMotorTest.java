package org.firstinspires.ftc.teamcode.hardware.test;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.function.Predicate;

public class DcMotorTest {
    private final DcMotor motor;

    public DcMotorTest(DcMotor motor) {
        this.motor = motor;
    }

    public DcMotor getMotor() {
        return motor;
    }

    public void assertMotorPowerIs(double expectedPower, double marginOfError) {
        assertPredicateIsTrue(motor -> Math.abs(motor.getPower() - expectedPower) <= marginOfError,
                "Motor power was not within range of expected " + expectedPower);
    }

    public void assertPredicateIsTrue(Predicate<DcMotor> predicate, String message) {
        if (!predicate.test(motor)) {
            throw new AssertionError(message);
        }
    }
    public void assertPredicateIsTrue(Predicate<DcMotor> predicate) {
        if (!predicate.test(motor)) {
            throw new AssertionError();
        }
    }
}
