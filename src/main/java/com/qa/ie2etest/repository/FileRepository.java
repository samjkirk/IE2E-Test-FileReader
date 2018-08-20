package com.qa.ie2etest.repository;

import java.io.File;
import java.util.List;

import com.qa.ie2etest.domain.FileInfo;

public interface FileRepository {

	List<File> getFilesFromDirectory(String path);

	FileInfo getInfoFromFile(File file);

	List<File> getFilesByMimeType(String mimeType);

	List<File> getFileByExtension(String extension);

}
