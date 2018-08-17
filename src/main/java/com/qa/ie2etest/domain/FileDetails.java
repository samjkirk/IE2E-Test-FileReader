package com.qa.ie2etest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileDetails {
	
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fileName;
	private String mimeType;
	private Long fizeSize;
	private String fileExtension;
	
	public FileDetails() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Long getFizeSize() {
		return fizeSize;
	}
	
	public void setFizeSize(Long fizeSize) {
		this.fizeSize = fizeSize;
	}
	
	public String getFileExtension() {
		return fileExtension;
	}
	
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	@Override
	public String toString() {
		return "FileDetails [id=" + id + ", fileName=" + fileName + ", mimeType=" + mimeType + ", fizeSize=" + fizeSize
				+ ", fileExtension=" + fileExtension + "]";
	}
	
	
}
