/**
 * 
 */
package com.capgemini.indiancensusanalyser;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mohana Kavya
 *
 */
public class StateCensusAnalyserTest {
	private static final Logger log = Logger.getLogger(StateCensusAnalyserTest.class.getName());
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	
    // Happy Test Case
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadStateCensus(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (Exception e) {
        	log.severe("Exception occured : "+e.getMessage());
        }
    }
}
