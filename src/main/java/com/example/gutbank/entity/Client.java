package com.example.gutbank.entity;

import com.example.gutbank.entity.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Client {
    /**
     * id varchar(40) NOT NULL,
     * manager_id INT NOT NULL,
     * status INT(1) NOT NULL,
     * tax_code varchar(20) NOT NULL,
     * first_name varchar(50) NOT NULL,
     * last_name varchar(50) NOT NULL,
     * email varchar(60) NOT NULL,
     * address varchar(80) NOT NULL,
     * phone varchar(20) NOT NULL,
     * created_at TIMESTAMP NOT NULL,
     * updated_at TIMESTAMP NOT NULL,
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @ManyToOne()
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClientStatus status;
    @Column(name = "tax_code")
    private String taxCode;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "ph[ne")
    private String phone;
    @Column(name = "creates_at")
    private int createdAt;
    @Column(name = "updated_at")
    private int updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Account> account = new HashSet<>();
}
