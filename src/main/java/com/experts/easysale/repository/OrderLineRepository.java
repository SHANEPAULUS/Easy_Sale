package com.experts.easysale.repository;

import com.experts.easysale.domain.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SHANE on 2015/10/13.
 */
@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine,Long> {
}
