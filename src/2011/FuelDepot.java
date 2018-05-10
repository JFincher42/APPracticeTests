public class FuelDepot {
    /** The robot used to move the filling mechanism */
    private FuelRobot filler;
    /** The list of fuel tanks */
    private List<FuelTank> tanks;

    /**
     * Determines and returns the index of the next tank to be filled.
     * 
     * @param threshold fuel tanks with a fuel level £ threshold may be filled
     * @return index of the location of the next tank to be filled Postcondition:
     *         the state of the robot has not changed
     */
    public int nextTankToFill(int threshold) {
        /* to be implemented in part (a) */ 
        int lowest = 0;
        int lowestLevel = tanks.get(lowest).getFuelLevel();
        for (int i=1; i<tanks.size(); i++){
            if (tanks.get(i).getFuelLevel() < lowestLevel){
                lowestLevel = tanks.get(i).getFuelLevel();
                lowest = i;
            }
        }
        if (lowestLevel <= threshold)
            return lowest;
        else
            return filler.getCurrentIndex();
    
    }

    /**
     * Moves the robot to location locIndex.
     * 
     * @param locIndex the index of the location of the tank to move to
     *                 Precondition: 0 <= locIndex < tanks.size() Postcondition: the
     *                 current location of the robot is locIndex
     */
    public void moveToLocation(int locIndex) {
        /* to be implemented in part (b) */
        int currentLocation = filler.getCurrentIndex();
        if (currentLocation == locIndex) return;

        if (currentLocation < locIndex){
            if (!filler.isFacingRight)
                filler.changeDirection();
            filler.moveForward(locIndex-currentLocation);
        }
        else {
            if (filler.isFacingRight())
                filler.changeDirection();
            filler.moveForward(currentLocation-locIndex);
        }
    
    }
    // There may be instance variables, constructors, and methods that are not
    // shown.
}