package com.example.gutbank.entity;

import com.example.gutbank.entity.enums.AccountProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agreement")
public class Agreement {
    /**
     * id INT NOT NULL ID_SEQ.NEXTVAL,
     * account_id varchar(40) NOT NULL,
     * product_id INT NOT NULL,
     * status INT(1) NOT NULL,
     * interest_rate decimal(10,5) NULL
     * created_at TIMESTAMP NOT NULL,
     * updated_at TIMESTAMP NOT NULL,
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountProductStatus status;
    @Column(name = "sum")
    private BigDecimal sum;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
