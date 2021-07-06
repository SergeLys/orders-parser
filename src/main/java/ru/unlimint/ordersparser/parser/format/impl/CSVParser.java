package ru.unlimint.ordersparser.parser.format.impl;

import ru.unlimint.ordersparser.model.Order;
import ru.unlimint.ordersparser.parser.format.FormatParser;

/**
 * The implementation of {@link FormatParser}
 * for parsing .csv format
 */

public class CSVParser implements FormatParser<String> {

    @Override
    public Order parse(String value) {
        Order order = new Order();
        try {
            String[] values = value.split(",");
            order.setId(Integer.valueOf(values[0]));
            order.setAmount(Integer.valueOf(values[1]));
            order.setCurrency(values[2]);
            order.setComment(values[3]);
            order.setResult("OK");
        } catch (Exception ex) {
            order.setResult(ex.getMessage());
        }
        return order;
    }

}
