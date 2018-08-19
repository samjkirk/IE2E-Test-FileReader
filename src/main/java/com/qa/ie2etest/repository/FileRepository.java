package com.qa.ie2etest.repository;

import java.io.File;
import java.util.List;

import com.qa.ie2etest.domain.FileInfo;
import com.qa.ie2etest.domain.Vehicle;

public interface FileRepository {
	
	FileInfo getInfoFromFile(String file);
	
	Vehicle getVehicleInfoFromFile(String file);

	List<File> getFilesFromDirectory(String path);
	
	List<File> getFilesByMimeType(String mimeType);
	
	List<File> getFileByExtension(String extension);

}
