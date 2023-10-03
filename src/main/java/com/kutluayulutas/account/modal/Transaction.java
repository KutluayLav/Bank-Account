package com.kutluayulutas.account.modal;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private TransactionType transactionType=TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY,optional = false , cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    public Transaction(BigDecimal amount, Account account) {
        this.id=null;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.transactionType=TransactionType.INITIAL;
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(getId(), that.getId())
                && getTransactionType() == that.getTransactionType() &&
                Objects.equals(getAmount(), that.getAmount()) &&
                Objects.equals(getTransactionDate(), that.getTransactionDate()) &&
                Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTransactionType(), getAmount(), getTransactionDate());
    }
}
