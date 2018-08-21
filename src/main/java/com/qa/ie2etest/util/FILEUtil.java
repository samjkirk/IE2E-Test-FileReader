package com.qa.ie2etest.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory; 
import org.apache.tika.Tika;

import com.qa.ie2etest.domain.FileInfo;
import com.qa.ie2etest.domain.Vehicle;
import com.qa.ie2etest.repository.FileRepositoryImpl;

public class FILEUtil {
	final static Logger LOGGER = Logger.getLogger(FileRepositoryImpl.class);
	
	private final static String SIZE = " bytes";
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	private Vehicle tempVehicle;
	private Tika tika = new Tika();
	private int vehicleCount = 0;
	
	public String getFileName(File file) {
		LOGGER.info("In FILEUtil getFileName of " + file.getName());
		return file.getName();
	}
	
	private String getFileSizeInBytes(File file) {
		LOGGER.info("In FILEUtil getFileSize of " + file.getName());
		return file.length() + SIZE;
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
	
	public ArrayList<Vehicle> readFileAndSetVehicleDetails(File file) throws EncryptedDocumentException, InvalidFormatException, IOException {
		LOGGER.info("In FILEUtil readFileAndSetVehicleDetails of" + file.getName());
		
		tempVehicle = new Vehicle();
		
		Workbook workbook = WorkbookFactory.create(new File(file.toString()));
		
		Sheet sheet = workbook.getSheetAt(0);
		
		DataFormatter dataFormatter = new DataFormatter();
		
		Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
            	
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                
                switch (cell.getColumnIndex()) {
                	case 0:
                		tempVehicle.setRegNumber(cellValue);
                		break;
                	case 1:
                		tempVehicle.setMake(cellValue);
                		break;
                	case 2:
                		tempVehicle.setColour(cellValue);
                		break;
                }
                vehicles.add(vehicleCount, tempVehicle);
                vehicleCount++;
            }
        }
        
        workbook.close();
        
        return vehicles;
	}
}
