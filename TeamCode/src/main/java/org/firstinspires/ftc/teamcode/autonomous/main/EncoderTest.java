package org.firstinspires.ftc.teamcode.autonomous.main;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;

@TeleOp(name = "Test: Encoder Test", group = "Test")
public class EncoderTest extends OpMode {

    DriveModule drive;

    @Override
    public void init() {
        drive = new DriveModule(hardwareMap, gamepad1, gamepad2, telemetry);

        drive.front_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        drive.loop();
        telemetry.addData("Position",drive.front_left.getCurrentPosition());
    }
}
