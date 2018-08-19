package com.qa.ie2etest.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.qa.ie2etest.domain.FileInfo;

public class FILEUtil {
	
	private String getFileName(File file) {
		return file.getName();
	}
	
	private String getFileSizeInBytes(File file) {
		return file.length() + "bytes";
	}
	
	public String getFileExtension(File file) {
		String extension = "";
        int count = file.getName().lastIndexOf('.');
        if (count > 0) {
            extension = file.getName().substring(count+1);
        }
        return extension;
	}
	
	public String getFileMimeType(File file) {
		String type;
		try {
			type = Files.probeContentType(file.toPath());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			type = null;
		}
		return type;
	}
	
	public FileInfo setFileInfo(File file) throws IOException {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(getFileName(file));
		fileInfo.setFileSize(getFileSizeInBytes(file));
		fileInfo.setMimeType(getFileMimeType(file));
		fileInfo.setFileExtension(getFileExtension(file));
		return fileInfo;
	}
}
