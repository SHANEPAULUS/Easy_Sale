package com.experts.easysale.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by SHANE on 2015/10/12.
 */
@Entity
public class Sale implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date postedDate;
    private Date expireDate;
    private List<Item> items;
    //private List<>


    public Sale() {
    }
}
