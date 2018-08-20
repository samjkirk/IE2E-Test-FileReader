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
	
	private static final String TEST_PATH = "C:\\Users\\samue\\git\\IE2E-Test-FileReader\\test_files";
	private static final String TEST_FILE = "\\SampleCSVFile_2kb.csv";
	private static final String MIME_TYPE = "text/csv";
	private static final String EXTENSION = "xls";
	private static final int SIZE1 = 11;
	private static final int SIZE2 = 7;
	private static final int SIZE3 = 3;

	@Before
	public void setUp() {
		fileService = new FileRepositoryImpl();
		fileUtil = new FILEUtil();
		testList = fileService.getFilesFromDirectory(TEST_PATH);
	}
	
	@Test
	public void testGetAllFilesFromDirectory() {
		Assert.assertEquals(SIZE1, fileService.getFilesFromDirectory(TEST_PATH).size());
	}

	@Test
	public void testGetInfoFromFile() {
		testFile = new File(TEST_PATH + TEST_FILE);
		
		try {
			expectedGetInfo = fileUtil.setFileInfo(testFile);
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		Assert.assertEquals(expectedGetInfo.getFileName(), fileService.getInfoFromFile(testFile).getFileName());
	}
	
	@Test
	public void testGetFilesByMimeType() {
		List<File> actualResultGetFilesByMimeType = fileService.getFilesByMimeType(MIME_TYPE);
		Assert.assertEquals(SIZE2, actualResultGetFilesByMimeType.size());
	}
	
	@Test
	public void testGetFilesByExtension() {
		List<File> actualResultGetFilesByExtension = fileService.getFileByExtension(EXTENSION);
		Assert.assertEquals(SIZE3, actualResultGetFilesByExtension.size());
	}
}
