package com.qa.ie2etest.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.qa.ie2etest.util.FILEUtil;
import com.qa.ie2etest.domain.FileInfo;
import com.qa.ie2etest.domain.Vehicle;

public class FileRepositoryImpl implements FileRepository {
	
	final static Logger LOGGER = Logger.getLogger(FileRepositoryImpl.class);

	private File directory; 
	private List<File> getAllList;
	private FILEUtil fileUtil = new FILEUtil();
	FileInfo fileInfo;
	private ArrayList<Vehicle> vehicleList;
	
	
	@Override
	public List<File> getFilesFromDirectory(String path) {
		LOGGER.info("In FileRepositoryImpl getFilesFromDirectory");
		directory = new File(path);
		getAllList = Arrays.asList(directory.listFiles());
		return getAllList;
	}

	@Override
	public FileInfo getInfoFromFile(File file) {
		LOGGER.info("In FileRepositoryImpl getInfoFromFile");
		try {
			fileInfo = fileUtil.setFileInfo(file);
		} catch (IOException e) {
			e.printStackTrace();
			fileInfo = null;
			LOGGER.info("In FileRepositoryImpl getInfoFromFile: IOException | filInfo = " + fileInfo);
		}
		return fileInfo;
	}

	@Override
	public List<File> getFilesByMimeType(String mimeType) {
		LOGGER.info("In FileRepositoryImpl getFilesByMimeType");
		
		List<File> filesToSearch = getListOfAllFiles();
		List<File> resultsOfSearch = new ArrayList<File>();
		
		for(File file : filesToSearch) {
			String tempMimeType = "";
			if (fileUtil.getFileMimeType(file) != null) {
				tempMimeType = fileUtil.getFileMimeType(file);
			}
			if (tempMimeType.equals(mimeType)) {
				resultsOfSearch.add(file);
			}
		}
		return resultsOfSearch;
	}

	@Override
	public List<File> getFileByExtension(String extension) {
		LOGGER.info("In FileRepositoryImpl getFileByExtension");
		
		List<File> filesToSearch = getListOfAllFiles();
		List<File> resultsOfSearch = new ArrayList<File>();
		
		for(File file : filesToSearch) {
			if (fileUtil.getFileExtension(file).equals(extension)) {
				resultsOfSearch.add(file);
			}
		}
		return resultsOfSearch;
	}
	
	public List<File> getListOfAllFiles(){
		LOGGER.info("In FileRepositoryImpl getListOfAllFiles");
		return getAllList;
	}

	@Override
	public ArrayList<Vehicle> setVehicleInfo(File file) {
		try {
			vehicleList = fileUtil.readFileAndSetVehicleDetails(file);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

}
