package com.experts.easysale.domain;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by SHANE on 2015/10/12.
 */
@Entity
public class Seller extends Person implements Serializable{
    public Seller() {
    }

    public Seller(Builder builder) {
        super(builder);
    }

}
