package ru.unlimint.ordersparser.parser.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.unlimint.ordersparser.model.Order;
import ru.unlimint.ordersparser.parser.FormatParser;

/**
 * The implementation of {@link FormatParser}
 * for parsing .json format
 */

public class JSONParser implements FormatParser<String> {

    @Override
    public Order parse(String value) {
        Order order = new Order();
        ObjectMapper mapper = new ObjectMapper();
        try {
            order = mapper.readValue(value, Order.class);
            order.setResult("OK");
        } catch (Exception ex) {
            order.setResult(ex.getMessage());
        }
        return order;
    }

}
