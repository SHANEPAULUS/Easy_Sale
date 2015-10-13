package com.experts.easysale.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SHANE on 2015/10/13.
 */
@Entity
public class Bid implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;

    public Bid() {
    }

    public Bid(Builder builder) {
        this.id=builder.id;
        this.amount=builder.amount;
    }

    public static class Builder{
        private Long id;
        private Double amount;

        public Builder(Double amt)
        {
            this.amount=amt;
        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }

        public Builder copy(Bid bid)
        {
            this.amount=bid.amount;
            this.id=bid.id;
            return this;
        }

        public Bid build()
        {
            return new Bid(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
