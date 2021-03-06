package battlecode.world.signal;

import battlecode.common.MapLocation;
import battlecode.common.MovementType;
import battlecode.engine.signal.Signal;
import battlecode.world.InternalRobot;

/**
 * Signifies that a robot has moved.
 *
 * @author Matt
 */
public class MovementSignal extends Signal {

    private static final long serialVersionUID = -6853620834787044985L;

    /**
     * TheID of the robot that moved.
     */
    private final int robotID;

    /**
     * The robot's new location.
     */
    private final MapLocation newLoc;

    /**
     * Whether the robot got to the new location by moving forward or backward.
     */
    private final boolean isMovingForward;

    private final int delay;

    private final MovementType mt;

    /**
     * Creates a signal for a robot movement.
     *
     * @param robot           the robot that is moving
     * @param newLoc          the robot's new location
     * @param isMovingForward whether the robot got to the new location by moving forward or backward
     */
    public MovementSignal(InternalRobot robot, MapLocation newLoc, boolean isMovingForward) {
        this(robot, newLoc, isMovingForward, 0);
    }

    /**
     * Creates a signal for a robot movement.
     *
     * @param robot           the robot that is moving
     * @param newLoc          the robot's new location
     * @param isMovingForward whether the robot got to the new location by moving forward or backward
     */
    public MovementSignal(InternalRobot robot, MapLocation newLoc, boolean isMovingForward, int delay) {
        this.robotID = robot.getID();
        this.newLoc = newLoc;
        this.isMovingForward = isMovingForward;
        this.delay = delay;
        this.mt = MovementType.RUN; // default
    }


    /**
     * Creates a signal for a robot movement.
     *
     * @param robot             the robot that is moving
     * @param newLoc            the robot's new location
     * @param isMovingForward   
     * @param delay
     * @param mt                movement type
     */
    public MovementSignal(InternalRobot robot, MapLocation newLoc, boolean isMovingForward, int delay, MovementType mt) {
        this.robotID = robot.getID();
        this.newLoc = newLoc;
        this.isMovingForward = isMovingForward;
        this.delay = delay;
        this.mt = mt;
    }

    /**
     * Returns the ID of the robot that just broadcast.
     *
     * @return the messaging robot's ID
     */
    public int getRobotID() {
        return robotID;
    }

    /**
     * The robot's new location.
     *
     * @return the robot's new MapLocation
     */
    public MapLocation getNewLoc() {
        return newLoc;
    }

    /**
     * Whether the robot got to the new location by moving forward or backward.
     */
    public boolean isMovingForward() {
        return isMovingForward;
    }

    public int getDelay() {
        return delay;
    }

    public MovementType getMovementType() {
        return mt;
    }
}
