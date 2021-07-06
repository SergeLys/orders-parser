package ru.unlimint.ordersparser;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.unlimint.ordersparser.parser.FileParser;
import ru.unlimint.ordersparser.parser.impl.CSVParser;
import ru.unlimint.ordersparser.parser.impl.JSONParser;

@SpringBootApplication
public class OrdersParserApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrdersParserApplication.class, args);
	}

	@Override
	public void run(String... args) {
		List<FileParser> fileParsers = new ArrayList<>();
		CSVParser csvParser = new CSVParser();
		JSONParser jsonParser = new JSONParser();
		for (String filename : args) {
			if (filename.endsWith(".csv")) {
				fileParsers.add(new FileParser(filename, csvParser));
			}
			if (filename.endsWith(".json")) {
				fileParsers.add(new FileParser(filename, jsonParser));
			}
		}
		fileParsers.parallelStream().forEachOrdered(FileParser::parse);
	}
}
