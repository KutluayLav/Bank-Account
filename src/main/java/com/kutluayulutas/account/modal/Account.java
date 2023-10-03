package com.kutluayulutas.account.modal;


import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id="";
    private BigDecimal balance= BigDecimal.ZERO;
    private  LocalDateTime credationDate;


    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Transaction> transaction= new HashSet<>();

    public Account(BigDecimal balance, LocalDateTime credationDate, Customer customer) {
        this.balance=balance;
        this.credationDate=credationDate;
        this.customer=customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId())
                && Objects.equals(getBalance(), account.getBalance())
                && Objects.equals(getCredationDate(), account.getCredationDate())
                && Objects.equals(getCustomer(), account.getCustomer())
                && Objects.equals(getTransaction(), account.getTransaction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getCredationDate(), getCustomer());
    }
}

