package controllers;

import dtos.IssueTicketResponseDto;
import dtos.IssueTicketRequestDto;
import exceptions.GateNotFoundException;
import models.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto IssueTicket(IssueTicketRequestDto issueTicketRequestDto){
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
        try{
            Ticket ticket = ticketService.issueTicket(
                    issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getOwnerName(),
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getOperatorId()
            );

            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }catch (GateNotFoundException | Exception e){
            responseDto.setResponseStatus(ResponseStatus.FALIED);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

}
