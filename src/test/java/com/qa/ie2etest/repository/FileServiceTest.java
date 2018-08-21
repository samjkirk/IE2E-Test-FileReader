package com.qa.ie2etest.repository;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Constants.Constants;
import com.qa.ie2etest.domain.FileInfo;
import com.qa.ie2etest.domain.Vehicle;
import com.qa.ie2etest.util.FILEUtil;

public class FileServiceTest {
	
	private FileRepositoryImpl fileService;
	private FILEUtil fileUtil;
	private File testFile;
	private List<File> testList;
	private FileInfo expectedGetInfo;
	private ArrayList<Vehicle> vehicleList;

	@Before
	public void setUp() {
		fileService = new FileRepositoryImpl();
		fileUtil = new FILEUtil();
		testList = fileService.getFilesFromDirectory(Constants.TEST_PATH);
	}
	
	@Test
	public void testGetAllFilesFromDirectory() {
		Assert.assertEquals(Constants.SIZE1, fileService.getFilesFromDirectory(Constants.TEST_PATH).size());
	}

	@Test
	public void testGetInfoFromFile() {
		testFile = new File(Constants.TEST_PATH + Constants.TEST_FILE);
		
		try {
			expectedGetInfo = fileUtil.setFileInfo(testFile);
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		Assert.assertEquals(expectedGetInfo.getFileName(), fileService.getInfoFromFile(testFile).getFileName());
	}
	
	@Test
	public void testGetFilesByMimeType() {
		List<File> actualResultGetFilesByMimeType = fileService.getFilesByMimeType(Constants.MIME_TYPE);
		Assert.assertEquals(Constants.SIZE2, actualResultGetFilesByMimeType.size());
	}
	
	@Test
	public void testGetFilesByExtension() {
		List<File> actualResultGetFilesByExtension = fileService.getFileByExtension(Constants.EXTENSION);
		Assert.assertEquals(Constants.SIZE3, actualResultGetFilesByExtension.size());
	}
	
	@Test
	public void testSetVehicleInfo() {
		testFile = new File(Constants.TEST_PATH + Constants.VEHICLE_DETAILS_FILE);
		vehicleList = fileService.setVehicleInfo(testFile);
		
		Assert.assertEquals(Constants.REG_NUMBER, vehicleList.get(0).getRegNumber());
	}
}
