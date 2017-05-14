package com.simongk.cart;

import com.simongk.event.Event;
import org.springframework.stereotype.Service;

/**
 * Created by Groobaz on 2017-05-05.
 */
@Service
public class DiscountService {

    private final String DISCOUNT_CODE="MJM2017RABAT";

    public double calculateCodeDiscount(double price, String discountCode) {
        if(discountCode.equals(DISCOUNT_CODE)){
            return calculateDiscount(price, 0.95);
        }
        else {
            System.out.println("No discount for you");
            return price;
        }
    }
    public double calculateTicketTypeDiscount(double price, String ticketType) {
        if (ticketType.equals("Ulgowy")) {
            System.out.println("nowa suma");
            return calculateDiscount(price, 0.8);
        } else {
            System.out.println("nothing happened");
            return price;
        }
    }

    public double calculateDiscount(double price, double discount) {
        return price*discount;
    }

}
