package com.example.gutbank.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {
    private String id;
    private String debitId;
    private String creditId;
    private int type;
    private BigDecimal amount;
    private String description;
    private Date createdAt;

}
