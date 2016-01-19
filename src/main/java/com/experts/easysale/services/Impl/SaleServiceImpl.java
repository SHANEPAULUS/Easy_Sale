package com.experts.easysale.services.Impl;

import com.experts.easysale.domain.Bid;
import com.experts.easysale.domain.Sale;
import com.experts.easysale.repository.SaleRepository;
import com.experts.easysale.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepository repository;

    @Override
    public List<Sale> getAllSales() {
        List<Sale> allSales=new ArrayList<Sale>();

        Iterable<Sale> sales=repository.findAll();
        for(Sale s:sales)
        {
            allSales.add(s);
        }

        return allSales;
    }

    @Override
    public List<Bid> getSaleBids(long id) {
        return repository.findOne(id).getBids();
    }

    @Override
    public Sale addSale(Sale sale) {
        return repository.save(sale);
    }

    @Override
    public Sale getSale(long id) {
        return repository.findOne(id);
    }

    @Override
    public Sale updateSale(Sale sale) {
        return repository.save(sale);
    }

    @Override
    public void deleteSale(Sale sale) {
        repository.delete(sale);
    }
}
