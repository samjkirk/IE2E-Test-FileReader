package com.qa.ie2etest.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qa.ie2etest.domain.Vehicle;
import com.qa.ie2etest.util.FILEUtil;
import com.qa.ie2etest.domain.FileInfo;

public class FileRepositoryImpl implements FileRepository {

	private File directory;
	private List<File> getAllList;
	private List<FileInfo> listOfFiles;
	private FILEUtil fileUtil = new FILEUtil();
	
	
	@Override
	public List<File> getFilesFromDirectory(String path) {
		directory = new File(path);
		getAllList = Arrays.asList(directory.listFiles());
		return getAllList;
	}

	@Override
	public FileInfo getInfoFromFile(String file) {
		FileInfo fileInfo = listOfFiles.stream()
				.filter(x -> file.equals(x.getFileName()))
				.findFirst()
				.orElse(null);
		return fileInfo;
	}

	@Override
	public Vehicle getVehicleInfoFromFile(String file) {
		FileInfo fileInfo = listOfFiles.stream()
				.filter(x -> file.equals(x.getFileName()))
				.findFirst()
				.orElse(null);
		return fileInfo.getVehicleDetails();
	}

	@Override
	public List<File> getFilesByMimeType(String mimeType) {
		List<File> filesToSearch = getListOfAllFiles();
		List<File> resultsOfSearch = new ArrayList<File>();
		for(File file : filesToSearch) {
			if (fileUtil.getFileMimeType(file).equals(mimeType)) {
				resultsOfSearch.add(file);
			}
		}
		return resultsOfSearch;
	}

	@Override
	public List<File> getFileByExtension(String extension) {
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
		return getAllList;
	}

}
