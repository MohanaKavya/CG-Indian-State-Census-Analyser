/**
 * 
 */
package com.capgemini.indiancensusanalyser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * @author Mohana Kavya
 *
 */
public class StateCensusAnalyser {
	private static final Logger log = Logger.getLogger(StateCensusAnalyser.class.getName());

	// Loading of CSV file into CSVStateCensus Class
	public static int loadStateCensus(String filePath) throws IOException  {
		try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
			) {
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
			Iterator<CSVStateCensus> csvIterator = csvToBean.iterator();
			int recordCount = 0;
			while(csvIterator.hasNext()) {
				recordCount++;
			}		
			log.log(Level.INFO, "Number of records", recordCount);
			return recordCount;
		}
	}

	public static void main(String[] args) {
		log.info("Welcome to Indian State Census Analyser");
	}
}
