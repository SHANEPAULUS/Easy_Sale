package com.experts.easysale.repository;

import com.experts.easysale.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SHANE on 2015/10/12.
 */
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice,Long> {
}
