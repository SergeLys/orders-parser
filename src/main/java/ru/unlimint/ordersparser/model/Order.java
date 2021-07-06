package ru.unlimint.ordersparser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class represents an order model
 */

@Data
@NoArgsConstructor
public class Order {

    @JsonProperty("orderId")
    private Integer id;
    private Integer amount;
    private String currency;
    private String comment;
    @JsonIgnore
    private String filename;
    @JsonIgnore
    private Integer line;
    @JsonIgnore
    private String result;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", comment='" + comment + '\'' +
                ", filename='" + filename + '\'' +
                ", line='" + line + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
