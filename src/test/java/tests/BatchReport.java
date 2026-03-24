package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.BatchReportPage;
import pages.DetailReportPage;
import utilities.ExistingFileDelete;
import utilities.ReadExcelData;
import utilities.ReadTextFile;

public class BatchReport extends BaseClass{
	
	int rawdatacount;
	BatchReportPage brp;
	
	
	@Test(priority = 1,enabled=false)
	public void readRawFile() throws IOException
	{
		ReadTextFile rtf = new ReadTextFile();
		rawdatacount = rtf.getRowCount();	
		System.out.println("raw data count : " + rawdatacount);
	}
	
	@Test(priority = 2)
	public void readDataExtraction() throws IOException, InterruptedException
	{
		brp = new BatchReportPage(driver);
		brp.clickdetailreportmodule()
		   .clicksubmodulereport();
		String downloadpath = System.getProperty("user.dir") + "\\Downloads\\DetailReport.zip";
		ExistingFileDelete.deleteFileIfExists(downloadpath);
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","Reports");
		brp.selectApplicationName(red.getCellData(4, 0).trim())
		   .selectProductName(red.getCellData(4, 1).trim())
		   .selectproducttype(red.getCellData(4, 2).trim())
		   .selectfromdateicon()
		   .setfromdate(red.getCellData(4, 3).trim())
		   .selecttodateicon()
		   .settodate(red.getCellData(4, 4).trim())
		   .submit()
		   .csvdownload();
	}

	
	
	

}
