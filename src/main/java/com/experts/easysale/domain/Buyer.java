package com.experts.easysale.domain;

import java.io.Serializable;

/**
 * Created by SHANE on 2015/10/12.
 */
public class Buyer extends Person implements Serializable {
    public Buyer() {
    }

    public Buyer(Builder builder) {
        super(builder);
    }
}
