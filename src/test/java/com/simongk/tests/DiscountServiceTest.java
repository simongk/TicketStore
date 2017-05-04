package com.simongk.tests;

import com.simongk.cart.Cart;
import com.simongk.cart.DiscountService;
import com.simongk.event.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Groobaz on 2017-05-04.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountServiceTest {

    @Autowired
    private DiscountService discountService;

    private Cart cart;
    private Event event;

    @Before
    public void setup(){
        cart = new Cart();
        event = new Event();
        event.setPrice(100);
    }

    @Test
    public void priceShouldBeDiscounted(){
        //given
        String ticketType = "Ulgowy";

        //when
        double result = discountService.calculateTicketTypeDiscount(event.getPrice(), ticketType);

        //then
        Assert.assertEquals(80, (int) result);
    }

    @Test
    public void discountCodeShouldWork(){
        //given
        String DISCOUNT_CODE = "MJM2017RABAT";
        cart.setDiscountCode(DISCOUNT_CODE);
        //when
        double result = discountService.calculateCodeDiscount(event.getPrice(), cart.getDiscountCode());

        //then
        Assert.assertEquals(95, (int) result);
    }

}

