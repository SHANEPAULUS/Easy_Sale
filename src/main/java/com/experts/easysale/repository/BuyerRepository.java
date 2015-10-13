package com.experts.easysale.repository;

import com.experts.easysale.domain.Buyer;
import com.experts.easysale.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SHANE on 2015/10/12.
 */
@Repository
public interface BuyerRepository extends CrudRepository<Person,Long> {
}
