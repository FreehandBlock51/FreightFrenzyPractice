package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.hardware.test.DcMotorTest;
import org.firstinspires.ftc.teamcode.modules.ActiveIntake;
import org.firstinspires.ftc.teamcode.modules.core.ModuleManager;

@Autonomous(group = TestOpMode.TEST_GROUP_NAME)
public class ActiveIntakeTest extends TestOpMode {
    public static final double MOTOR_POWER_THRESHOLD = 0.001;

    /**
     * Runs the test
     *
     * @param manager A module manager that can be used to retrieve needed modules
     * @throws InterruptedException If this thread is interrupted
     */
    @Override
    public void runTest(ModuleManager manager) throws InterruptedException {

        final ActiveIntake intake  = manager.getModule(ActiveIntake.class);
        final DcMotor intakeMotor = hardwareMap.get(DcMotor.class, ActiveIntake.INTAKE_MOTOR_NAME);
        final DcMotorTest intakeTest = new DcMotorTest(intakeMotor);

        intake.activate();
        Thread.sleep(1000);
        intakeTest.assertMotorPowerIs(ActiveIntake.INTAKE_POWER, MOTOR_POWER_THRESHOLD);
        intake.deactivate();
        Thread.sleep(1000);
        intakeTest.assertMotorPowerIs(0.0, MOTOR_POWER_THRESHOLD);
        intake.toggleActivity();
        Thread.sleep(1000);
        intakeTest.assertMotorPowerIs(ActiveIntake.INTAKE_POWER, MOTOR_POWER_THRESHOLD);
        intake.toggleActivity();
        Thread.sleep(1000);
        intakeTest.assertMotorPowerIs(0.0, MOTOR_POWER_THRESHOLD);
    }
}
