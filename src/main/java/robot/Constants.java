package robot;

import org.ghrobotics.lib.mathematics.twodim.geometry.Pose2dWithCurvature;
import org.ghrobotics.lib.mathematics.twodim.trajectory.constraints.CentripetalAccelerationConstraint;
import org.ghrobotics.lib.mathematics.twodim.trajectory.constraints.TimingConstraint;
import org.ghrobotics.lib.mathematics.units.LengthKt;
import org.ghrobotics.lib.mathematics.units.derivedunits.AccelerationKt;

import java.util.ArrayList;
import java.util.List;

import static robot.Utilities.metersToRadians;

/**
 * A class holding all of the constants of every mechanism on the robot.
 * Place global constants in this class, and mechanism-specific constants inside their respective mechanism subclass.
 * When accessing a mechanism-specific port, call Constants.[MECHANISM].[CONSTANT]
 */
public class Constants {

    static {
        Drivetrain.constraints.add(new CentripetalAccelerationConstraint(AccelerationKt.getAcceleration(LengthKt.getMeter(Constants.Drivetrain.ACCELERATION_CONSTRAINT))));
    }

    public static class Drivetrain {

        public static final double TICKS_PER_ROTATION = 1920;

        public static final double MAX_VELOCITY = 1;
        public static final double MAX_ACCEL = 1;

        public static final double WHEEL_DIAMATER = 0.1524; // meters. TODO tune
        public static final double ROBOT_WIDTH = 0.75; // meters
        public static final double ROBOT_MASS = 59.7; //Robot Mass + 5kg for the battery + 2kg for the bumpers

        public static final double kBeta = 2;
        public static final double kZeta = 0.7;

        public static final double kVDriveLeftLow = metersToRadians(1.98); // Volts per radians per second - Calculated empirically 1.98
        public static final double kADriveLeftLow = metersToRadians(0.909); // Volts per radians per second per second 0.909
        public static final double kVInterceptLeftLow = metersToRadians(1.43); // Volts 1.43

        public static final double kVDriveRightLow = metersToRadians(1.88); // Volts per radians per second - Calculated empirically 1.88
        public static final double kADriveRightLow = metersToRadians(0.811); // Volts per radians per second per second 0.811
        public static final double kVInterceptRightLow = metersToRadians(1.42); // Volts 1.42

        public static final double MOMENT_OF_INERTIA = 10;// kg m^2
        public static final double ANGULAR_DRAG = 12;// N*m / (rad/sec)

        public static final double[] RIGHT_TALON_VELOCITY_PID = {4, 0.006, 10, 0};
        public static final double[] LEFT_TALON_VELOCITY_PID = {4, 0.006, 10, 0.1};

        public static final double[] RIGHT_TALON_VELOCITY_PID_MODEL = {4, 0.006, 10, 0};
        public static final double[] LEFT_TALON_VELOCITY_PID_MODEL = {4, 0.006, 10, 0};
        //******************
        //***Constraints****
        //******************
        public static final List<TimingConstraint<Pose2dWithCurvature>> constraints = new ArrayList<>();
        public static final double ACCELERATION_CONSTRAINT = 1.2;
        private static final double VELOCITY_CONSTRAINT = 3;
    }
}