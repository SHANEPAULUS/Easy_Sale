package com.experts.easysale.services;

import com.experts.easysale.domain.Bid;
import com.experts.easysale.domain.Sale;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public interface SaleService {
    List<Sale> getAllSales();
    List<Bid> getSaleBids(long id);
    Sale addSale(Sale sale);
    Sale getSale(long id);
    Sale updateSale(Sale sale);
    void deleteSale(Sale sale);
}
