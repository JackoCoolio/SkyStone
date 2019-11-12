package org.firstinspires.ftc.teamcode.leelo;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.leelo.modules.ArmModule;
import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;
import org.firstinspires.ftc.teamcode.leelo.modules.HandModule;
import org.firstinspires.ftc.teamcode.modules.ModularOpMode;

@TeleOp(name = "Leelo")
public class LeeloModular extends ModularOpMode {

    @Override
    protected void initModules() {
        registerModules(/*HandModule.class, ArmModule.class, */ DriveModule.class);
    }
}
