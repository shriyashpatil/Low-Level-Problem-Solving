package strategies.spot_assignment;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

public interface SpotAssignmentStrategy {

    ParkingSpot assignParkingSpot(ParkingLot parkingLot,Vehicle vehicle);

}
