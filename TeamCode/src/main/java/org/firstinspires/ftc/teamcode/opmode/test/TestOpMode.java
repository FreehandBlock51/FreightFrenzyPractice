package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.modules.core.ModuleManager;

/**
 * Represents an OpMode that tests one or more modules
 */
public abstract class TestOpMode extends LinearOpMode {
    /**
     * All test OpModes can specify that they are in this group
     */
    public static final String TEST_GROUP_NAME = "Tests";

    /**
     * Runs the test
     * @param manager A module manager that can be used to retrieve needed modules
     * @throws InterruptedException If this thread is interrupted
     */
    public abstract void runTest(ModuleManager manager) throws InterruptedException;

    /**
     * Override this method and place your code here.
     * <p>
     * Please do not catch {@link InterruptedException}s that are thrown in your OpMode
     * unless you are doing it to perform some brief cleanup, in which case you must exit
     * immediately afterward. Once the OpMode has been told to stop, your ability to
     * control hardware will be limited.
     *
     * @throws InterruptedException When the OpMode is stopped while calling a method
     *                              that can throw {@link InterruptedException}
     */
    @Override
    public final void runOpMode() throws InterruptedException {
        final ModuleManager manager = new ModuleManager(this);

        waitForStart();

        runTest(manager);
    }
}
