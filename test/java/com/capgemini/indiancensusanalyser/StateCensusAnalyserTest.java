/**
 * 
 */
package com.capgemini.indiancensusanalyser;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.indiancensusanalyser.CensusAnalyserException.ExceptionType;

/**
 * @author Mohana Kavya
 *
 */
public class StateCensusAnalyserTest {
	private static final Logger log = Logger.getLogger(StateCensusAnalyserTest.class.getName());
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_TYPE="./src/test/resources/IndiaStateCensusData.java";

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
    // Sad Test Case
    @Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		try {
			censusAnalyser.loadStateCensus(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        	log.severe("Exception occured : "+e.getMessage());
		}
	}
    // Sad Test Case
    @Test 
	public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
		StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
		try {
			censusAnalyser.loadStateCensus(WRONG_CSV_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        	log.severe("Exception occured : "+e.getMessage());
		}
	}
}
