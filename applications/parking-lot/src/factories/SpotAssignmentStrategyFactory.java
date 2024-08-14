package factories;

import models.ParkingSpotStrategyType;
import strategies.spot_assignment.NearestSpotAssignmentStrategy;
import strategies.spot_assignment.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getParkingSpotStrategy(ParkingSpotStrategyType parkingSpotStrategyType){

        if(parkingSpotStrategyType.equals(ParkingSpotStrategyType.NEAREST)) new NearestSpotAssignmentStrategy();

        return null;

    }

}
