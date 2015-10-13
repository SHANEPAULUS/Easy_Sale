package com.experts.easysale.services;

import com.experts.easysale.domain.OrderLine;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public interface OrderLineService {
    List<OrderLine> getAllOrderLines();
    OrderLine getOrderLine(long id);
    OrderLine updateOrderLine(OrderLine orderLine);
    OrderLine addOrderLine(OrderLine orderLine);
    void deleteOrderLine(OrderLine orderLine);
}
