package com.example.gutbank.entity;

import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")

public class Product {
    /**
     * id INT NOT NULL ID_SEQ.NEXTVAL,
     * managet_id INT NOT NULL,
     * name varchar(70) NOT NULL,
     * status INT(1) NOT NULL,
     * curency_code INT(2) NOT NULL,
     * interest_rate INT(1) NOT NULL,
     * limit INT NOT NULL,
     * created_at TIMESTAMP NOT NULL,
     * updated_at TIMESTAMP NOT NULL,
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;
    @Column(name = "currency_code")
    @Enumerated(EnumType.ORDINAL)
    private Currencies currency;
    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    @Column(name = "limit")
    private int limit;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return createdAt == product.createdAt && Objects.equals(name, product.name) && currency == product.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currency, createdAt);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", currency=" + currency +
                ", interestRate=" + interestRate +
                ", limit=" + limit +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", manager=" + manager +
                '}';
    }
}