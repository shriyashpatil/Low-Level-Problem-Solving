import controllers.TicketController;
import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import factories.SpotAssignmentStrategyFactory;
import models.ParkingSpotStrategyType;
import repositories.GateRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.spot_assignment.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getParkingSpotStrategy(ParkingSpotStrategyType.NEAREST);
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository();
        TicketService ticketService = new TicketService(gateRepository,vehicleRepository,spotAssignmentStrategy);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setOperatorId(123344L);
        requestDto.setOwnerName("Shri");
        requestDto.setVehicleNumber("MH12RS4550");

        IssueTicketResponseDto issueTicketResponseDto = ticketController.IssueTicket(requestDto);

    }
}