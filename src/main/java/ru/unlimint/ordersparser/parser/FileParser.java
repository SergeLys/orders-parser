package ru.unlimint.ordersparser.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import ru.unlimint.ordersparser.model.Order;
import ru.unlimint.ordersparser.parser.format.FormatParser;

/**
 * The class for parsing file
 */

@Slf4j
public class FileParser {

    private String filename;
    private FormatParser parser;

    public FileParser(String filename, FormatParser parser) {
        this.filename = filename;
        this.parser = parser;
    }

    /**
     * This method reads the file line by line
     * and parses line with {@link FormatParser}
     */

    public void parse() {
        try (
                FileInputStream fis = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(isr)
        ) {
            int line = 1;
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                Order order = parser.parse(value);
                order.setLine(line++);
                order.setFilename(filename);
                System.out.println(order.toString());
            }
        } catch (Exception ex) {
            log.info(ex.getMessage(), ex);
        }
    }

}
