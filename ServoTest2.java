package Centerstage;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "ServoTest2") 
public class ServoTest2 extends LinearOpMode {

    private CRServo a;
    boolean clockwise;
    double limit;
    
    @Override
    public void runOpMode() {
        a = hardwareMap.get(CRServo.class, "servo");
      
        waitForStart();

        // initialization goes here, ex. reverse motor direction

        a.setDirection(DcMotor.Direction.REVERSE);
        clockwise = true;

        if (opModeIsActive()) {
            a.setPower(0);
            limit = 1;
            telemetry.addData("Left stick up/down position", gamepad1.left_stick_y);
            telemetry.addData("Clockwise", clockwise);
            telemetry.addData("Limit", limit);

            while(opModeIsActive()) {
                telemetry.addData("Left stick up/down position", gamepad1.left_stick_y);
                telemetry.addData("Clockwise", clockwise);
                telemetry.addData("Limit", limit);
                telemetry.update();
                a.setPower(gamepad1.left_stick_y * limit);

                if (gamepad1.a) {
                    a.setDirection(DcMotor.Direction.FORWARD);
                    clockwise = false;
                  } else if (gamepad1.b) {
                    a.setDirection(DcMotor.Direction.REVERSE);
                    clockwise = true;
                  }

                  if (gamepad1.y) {
                    limit += 0.1;
                    sleep(300);
                  } else if (gamepad1.x) {
                    limit -= 0.1;
                    sleep(300);
                  }
          
                  if (limit >= 1) {
                    limit = 1;
                  } else if (limit <= 0) {
                    limit = 0;
                  }
        

            }

        }
    }
}