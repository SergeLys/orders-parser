package ru.unlimint.ordersparser;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.unlimint.ordersparser.parser.FileParser;
import ru.unlimint.ordersparser.parser.format.impl.CSVParser;
import ru.unlimint.ordersparser.parser.format.impl.JSONParser;

@Slf4j
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
				continue;
			}
			if (filename.endsWith(".json")) {
				fileParsers.add(new FileParser(filename, jsonParser));
				continue;
			}
			log.info(String.format("Can't parse the file: %s", filename));
		}
		fileParsers.parallelStream().forEachOrdered(FileParser::parse);
	}

}
