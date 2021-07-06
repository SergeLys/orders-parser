package ru.unlimint.ordersparser.parser.format;

import ru.unlimint.ordersparser.model.Order;

/**
 * Represents an operation that accepts a single input argument
 * and returns {@link Order}
 */

public interface FormatParser<T> {

    Order parse(T value);

}
