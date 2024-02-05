package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.hardware.test.DcMotorTest;
import org.firstinspires.ftc.teamcode.modules.DuckRetriever;
import org.firstinspires.ftc.teamcode.modules.core.ModuleManager;

@Autonomous(group = TestOpMode.TEST_GROUP_NAME)
public class DuckRetrieverTest extends TestOpMode {
    /**
     * Runs the test
     *
     * @param manager A module manager that can be used to retrieve needed modules
     */
    @Override
    public void runTest(ModuleManager manager) {
        DuckRetriever retriever = manager.getModule(DuckRetriever.class);
        DcMotorTest spinnerMotorTest = new DcMotorTest(hardwareMap.get(DcMotor.class, DuckRetriever.SPINNER_MOTOR_NAME));

        retriever.retrieveDuck();
        spinnerMotorTest.assertPredicateIsTrue(motor -> motor.getCurrentPosition() >= DuckRetriever.TARGET_POSITION_OFFSET);
    }
}
