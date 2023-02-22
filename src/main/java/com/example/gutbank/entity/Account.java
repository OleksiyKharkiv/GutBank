package com.example.gutbank.entity;

import com.example.gutbank.entity.enums.AccountStatus;
import com.example.gutbank.entity.enums.AccountType;
import com.example.gutbank.entity.enums.Currencies;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    /**
     * `id` varchar(40) NOT NULL,
     * `client_id` INT NOT NULL,
     * `name` varchar(100) NOT NULL,
     * `type` INT(1) NOT NULL,
     * `status` INT(1) NOT NULL,
     * `balance` DECIMAL(15,2) NOT NULL,
     * `currency_code` INT(2) NOT NULL,
     * `created_at` TIMESTAMP NOT NULL,
     * `updated_at` TIMESTAMP NOT NULL,
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private AccountType type;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @Column(name = "balance")
    @Enumerated(EnumType.ORDINAL)
    private float balance;
    @Column(name = "currency_code")
    private Currencies currencyCode;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "debitAccountId")
    private Set<Transaction> debitTransaction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditAccountId")
    private Set<Transaction> creditTransaction;
}