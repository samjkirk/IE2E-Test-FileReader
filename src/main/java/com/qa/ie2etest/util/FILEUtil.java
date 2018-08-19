package com.qa.ie2etest.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.log4j.Logger;
import org.apache.tika.Tika;

import com.qa.ie2etest.domain.FileInfo;
import com.qa.ie2etest.repository.FileRepositoryImpl;

public class FILEUtil {
	final static Logger LOGGER = Logger.getLogger(FileRepositoryImpl.class);
	
	private Tika tika = new Tika();
	
	public String getFileName(File file) {
		LOGGER.info("In FILEUtil getFileName of " + file.getName());
		return file.getName();
	}
	
	private String getFileSizeInBytes(File file) {
		LOGGER.info("In FILEUtil getFileSize of " + file.getName());
		return file.length() + "bytes";
	}
	
	public String getFileExtension(File file) {
		LOGGER.info("In FILEUtil getFileExtension of" + file.getName());
		String extension = "";
        int count = file.getName().lastIndexOf('.');
        if (count > 0) {
            extension = file.getName().substring(count+1);
        }
        return extension;
	}
	
	public String getFileMimeType(File file) {
		LOGGER.info("In FILEUtil getFileMimeType of" + file.getName());
		String type;
		try {
			type = tika.detect(file);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			type = null;
		}
		return type;
	}
	
	public FileInfo setFileInfo(File file) throws IOException {
		LOGGER.info("In FILEUtil setFileInfo of");
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(getFileName(file));
		fileInfo.setFileSize(getFileSizeInBytes(file));
		fileInfo.setMimeType(getFileMimeType(file));
		fileInfo.setFileExtension(getFileExtension(file));
		return fileInfo;
	}
}
