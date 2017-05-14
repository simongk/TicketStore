package com.simongk.ticket;

import com.simongk.cart.DiscountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szymon on 14.05.17.
 */
@Service
public class TicketService {

    private final DiscountService discountService;

    public TicketService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public double getTotalCost(double eventPrice, List<Ticket> ticketList) {
        List<Double> ticketPrices = getAllTicketPrices(eventPrice,ticketList);
        return ticketPrices
                .stream()
                .reduce(0.0, (a, b) -> a + b);
    }

    private List<Double> getAllTicketPrices(double price, List<Ticket> ticketList) {
        List<Double> ticketPrices = new ArrayList<>(2);

        for(Ticket ticket: ticketList){
            if(ticket.getType().equals("Ulgowy")){
                ticketPrices.add(ticket.getQuantity() * discountService.calculateDiscount(price, 0.8));
            }
            else {
                ticketPrices.add(ticket.getQuantity() * price);
            }
        }
        return ticketPrices;
    }

}
