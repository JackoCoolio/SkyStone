package org.firstinspires.ftc.teamcode.leelo.modules;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.Module;
import org.firstinspires.ftc.teamcode.utility.Button;

public class HookModule extends Module {

    Servo hookA, hookB;
    final double a_up = 1d;
    final double a_down = 0d;
    final double b_up = 1d;
    final double b_down = 0d;

    Button button;

    public HookModule(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) {
        super(hardwareMap, gamepad1, gamepad2, telemetry);
    }

    @Override
    public void init() {
        button = new Button(false);
        hookA = hardwareMap.servo.get("hook_a");
        hookB = hardwareMap.servo.get("hook_b");
    }

    @Override
    public void loop() {

        button.update(gamepad1.dpad_down);

        if (button.getState()) {
            setPosition(Position.Down);
        } else {
            setPosition(Position.Up);
        }

    }

    @Override
    public void telemetry() {
        telemetry.addData("Hook Position", button.getState());
    }

    public enum Position {Down, Up};
    public void setPosition(Position position) {
        switch (position) {
            case Down:
                hookA.setPosition(a_down);
                hookB.setPosition(b_down);
                break;
            case Up:
                hookA.setPosition(a_up);
                hookB.setPosition(b_up);
        }
    }

}
