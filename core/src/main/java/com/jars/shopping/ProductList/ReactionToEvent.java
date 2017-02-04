package com.jars.shopping.ProductList;

import javax.enterprise.event.Observes;

/**
 * Created by keehoo on 04.02.17.
 */
public class ReactionToEvent {

    public void putToProductApi(@Observes ApiEventFire apiEventFire)  {

        apiEventFire.getProduct();
        apiEventFire.getUserName();

        //TODO: Make Client To store products in API

    }
}
