package com.qa.ie2etest.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.ie2etest.domain.FileInfo;
import com.qa.ie2etest.util.FILEUtil;

public class FileServiceTest {
	
	private FileRepositoryImpl fileService;
	private FILEUtil fileUtil;
	private File testFile;
	private List<File> testList;
	private FileInfo expectedGetInfo;	

	@Before
	public void setUp() {
		fileService = new FileRepositoryImpl();
		fileUtil = new FILEUtil();
		testList = fileService.getFilesFromDirectory("C:\\Users\\samue\\git\\IE2E-Test-FileReader\\test_files");
	}
	
	@Test
	public void testGetAllFilesFromDirectory() {
		Assert.assertEquals(11, fileService.getFilesFromDirectory("C:\\Users\\samue\\git\\IE2E-Test-FileReader\\test_files").size());
	}

	@Test
	public void testGetInfoFromFile() {
		testFile = new File("C:\\Users\\samue\\git\\IE2E-Test-FileReader\\test_files\\SampleCSVFile_2kb.csv");
		
		try {
			expectedGetInfo = fileUtil.setFileInfo(testFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(expectedGetInfo.getFileName(), fileService.getInfoFromFile(testFile).getFileName());
	}
	
	@Test
	public void testGetFilesByMimeType() {
		List<File> actualResultGetFilesByMimeType = fileService.getFilesByMimeType("text/csv");
		Assert.assertEquals(7, actualResultGetFilesByMimeType.size());
	}
	
	@Test
	public void testGetFilesByExtension() {
		List<File> actualResultGetFilesByExtension = fileService.getFileByExtension("xls");
		Assert.assertEquals(3, actualResultGetFilesByExtension.size());
	}
}
