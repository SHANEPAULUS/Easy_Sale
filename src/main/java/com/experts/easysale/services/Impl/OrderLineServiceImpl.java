package com.experts.easysale.services.Impl;

import com.experts.easysale.domain.OrderLine;
import com.experts.easysale.repository.OrderLineRepository;
import com.experts.easysale.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    OrderLineRepository repository;

    @Override
    public List<OrderLine> getAllOrderLines() {
        List<OrderLine> allOrderLines=new ArrayList<OrderLine>();

        Iterable<OrderLine> orders=repository.findAll();
        for(OrderLine orderLine:orders)
        {
            allOrderLines.add(orderLine);
        }

        return allOrderLines;
    }

    @Override
    public OrderLine getOrderLine(long id) {
        return repository.findOne(id);
    }

    @Override
    public OrderLine updateOrderLine(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    @Override
    public OrderLine addOrderLine(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    @Override
    public void deleteOrderLine(OrderLine orderLine) {
        repository.delete(orderLine);
    }
}
