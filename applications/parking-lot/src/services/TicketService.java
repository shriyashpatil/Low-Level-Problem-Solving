package services;

import exceptions.GateNotFoundException;
import models.Gate;
import models.ParkingSpotStrategyType;
import models.Ticket;
import models.Vehicle;
import repositories.GateRepository;
import repositories.VehicleRepository;
import strategies.spot_assignment.SpotAssignmentStrategy;

import java.time.LocalDateTime;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,SpotAssignmentStrategy spotAssignmentStrategy){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public Ticket issueTicket(String vehicleNumber,String ownerName,Long gateId,Long operatorId) throws GateNotFoundException {

        /// create a ticket object
        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ///Get the Gate Object
        Optional<Gate> opGate = gateRepository.findGateById(gateId);
        if(opGate.isEmpty()) {
            throw new GateNotFoundException("Invalid Gate");
        }
        Gate gate = opGate.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        /// Get or create vehicle
        Optional<Vehicle> opVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle=null;
        if(opVehicle.isEmpty()){
            ///create vehicle and save
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            savedVehicle = vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(savedVehicle);

        /// parking spot
        ticket.setParkingSpot(spotAssignmentStrategy.assignParkingSpot(gate.getParkingLot(),savedVehicle));

        return null;
    }

}
