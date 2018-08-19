package com.qa.ie2etest.domain;

public class FileInfo {
	
	private String fileName;
	private String mimeType;
	private String fileSize;
	private String fileExtension;
	
	public FileInfo() {}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public String getFileSize() {
		return fileSize;
	}
	
	public void setFileSize(String fizeSize) {
		this.fileSize = fizeSize;
	}
	
	public String getFileExtension() {
		return fileExtension;
	}
	
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	@Override
	public String toString() {
		return "FileDetails [fileName=" + fileName + ", mimeType=" + mimeType + ", fizeSize=" + fileSize
				+ ", fileExtension=" + fileExtension + "]";
	}
	
	
}
