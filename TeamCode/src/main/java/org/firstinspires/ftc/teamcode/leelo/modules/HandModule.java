package org.firstinspires.ftc.teamcode.leelo.modules;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.Module;
import org.firstinspires.ftc.teamcode.utility.Button;

public class HandModule extends Module {

    public Servo hand;

    Button handToggle;

    public static final float CLOSED = .27f, OPEN = .85f;

    public HandModule(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) {
        super(hardwareMap, gamepad1, gamepad2, telemetry);
    }

    @Override
    public void init() {
        hand = hardwareMap.servo.get("hand");
        hand.setDirection(Servo.Direction.REVERSE);
        handToggle = new Button(true);
    }

    @Override
    public void loop() {
        handToggle.update(gamepad1.right_bumper);
        if (handToggle.getState()) {
            setPosition(Position.CLOSED);
        } else {
            setPosition(Position.OPEN);
        }
//        hand.setPosition(gamepad1.right_trigger);
    }

    public enum Position {OPEN, CLOSED};
    public void setPosition(Position pos) {
        if (pos == Position.CLOSED) {
            hand.setPosition(CLOSED);
        } else if (pos == Position.OPEN) {
            hand.setPosition(OPEN);
        }
    }

    @Override
    public void telemetry() {
        //telemetry.addData("Hand Position", handToggle.getState()? "closed" : "open");
        telemetry.addData("Servo",hand.getPosition());
    }
}
