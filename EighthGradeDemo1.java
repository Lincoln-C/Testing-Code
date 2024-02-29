package Centerstage;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "EighthGradeDemo1") 
public class EighthGradeDemo1 extends LinearOpMode {

    private DcMotor red;
    private DcMotor blue;
    
    @Override
    public void runOpMode() {
        red = hardwareMap.get(DcMotor.class, "red");
        blue = hardwareMap.get(DcMotor.class, "blue");

      
        waitForStart();

        // initialization goes here, ex. reverse motor direction

        blue.setDirection(DcMotor.Direction.REVERSE);

        if (opModeIsActive()) {


            while(opModeIsActive()) {

                telemetry.update();
                red.setPower(gamepad1.right_stick_y);
                blue.setPower(gamepad1.left_stick_y);
        

            }

        }
    }
}