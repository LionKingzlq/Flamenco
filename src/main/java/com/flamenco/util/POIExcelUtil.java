package com.flamenco.util;

import java.io.File;
import java.io.IOException;
import javax.annotation.Resource;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.flamenco.model.User;
import com.flamenco.service.IUserService;

@Component(value="poiExcelUtil")
public class POIExcelUtil {
	
	@Resource(name = "userService")
	private IUserService userService;
	
	public boolean saveUsersToDataBase(String filePath) {
		
		if(!filePath.endsWith(".xlsx") && !filePath.endsWith(".xls")){
			return false;
		}
		try {
			
			Workbook workbook = WorkbookFactory.create(new File(filePath));
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				for (int j = 1; j < sheet.getLastRowNum()+1; j++) {
					User user = new User();
					Row row = sheet.getRow(j);
					user.setName(row.getCell(0).getStringCellValue());
					user.setPassword(row.getCell(1).getStringCellValue());
					user.setPhone(String.valueOf((long)row.getCell(2).getNumericCellValue()));
					user.setGender(row.getCell(3).getBooleanCellValue());
					user.setAddress(row.getCell(4).getStringCellValue());
					user.setType((int)row.getCell(5).getNumericCellValue());
					userService.save(user);
				}
			}
			return true;
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void main(String[] args){
		try {
			Workbook workbook = WorkbookFactory.create(new File("/Users/abraham/Desktop/name.xlsx"));
			System.out.println(workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
