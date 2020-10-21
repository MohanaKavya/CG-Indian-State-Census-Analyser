/**
 * 
 */
package com.capgemini.indiancensusanalyser;

/**
 * @author Mohana Kavya
 *
 */
public class CensusAnalyserException extends Exception {
	enum ExceptionType {
		CENSUS_FILE_PROBLEM
	}
	ExceptionType type;
	public CensusAnalyserException(String msg, ExceptionType type) {
		super(msg);
		this.type = type;
	}
}
