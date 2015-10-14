package com.experts.easysale.services.Impl;

import com.experts.easysale.domain.Bid;
import com.experts.easysale.repository.BidReposity;
import com.experts.easysale.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@Service
public class BidServiceImpl implements BidService {
    @Autowired
    BidReposity reposity;

    @Override
    public List<Bid> getAllBids() {
        List<Bid> allBids=new ArrayList<Bid>();

        Iterable<Bid> bids=reposity.findAll();
        for(Bid bid:bids)
        {
            allBids.add(bid);
        }

        return allBids;
    }

    @Override
    public Bid addBid(Bid bid) {
        return reposity.save(bid);
    }

    @Override
    public Bid getBid(Long id) {
        return reposity.findOne(id);
    }

    @Override
    public Bid updateBid(Bid bid) {
        return reposity.save(bid);
    }

    @Override
    public void deleteBid(Bid bid) {
        reposity.delete(bid);
    }
}
