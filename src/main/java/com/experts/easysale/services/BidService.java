package com.experts.easysale.services;

import com.experts.easysale.domain.Bid;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public interface BidService {
    List<Bid> getAllBids();
    Bid getBid(Long id);
    Bid updateBid(Bid bid);
    void deleteBid(Bid bid);

}
