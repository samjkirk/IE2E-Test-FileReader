package com.qa.ie2etest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileInfo {
	
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fileName;
	private String mimeType;
	private String fileSize;
	private String fileExtension;
	private Vehicle vehicleDetails;
	
	public FileInfo() {}
	
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

	public Vehicle getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(Vehicle vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	@Override
	public String toString() {
		return "FileDetails [id=" + id + ", fileName=" + fileName + ", mimeType=" + mimeType + ", fizeSize=" + fileSize
				+ ", fileExtension=" + fileExtension + "]";
	}
	
	
}
