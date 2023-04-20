package com.example.gutbank.dto;

import com.example.gutbank.entity.Manager;
import com.example.gutbank.entity.enums.Currencies;
import com.example.gutbank.entity.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.math.BigDecimal;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity of Product")
@Value
public class ProductDto {
    @ApiModelProperty(notes = "Unique identifier of the product")
    String id;
    @ApiModelProperty(notes = "Name of the product")
    String name;
    @ApiModelProperty(notes = "Status of the product")
    ProductStatus status;
    @ApiModelProperty(notes = "Currency code of the product")
    Currencies currency;
    @ApiModelProperty(notes = "Interest rate of the product")
//    @DecimalMin(value = "0.01", message = "Interest rate should not be less than 0.01")
    BigDecimal interestRate;
    @ApiModelProperty(notes = "Limit of the product")
    String limit;
    @ApiModelProperty(notes = "Timestamp when the product was created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp createdAt;
    @ApiModelProperty(notes = "Timestamp when the product was last updated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Timestamp updatedAt;
    @ApiModelProperty(notes = "Manager associated with the product")
    Manager manager;
}