package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DetailReportPage;
import utilities.ExistingFileDelete;
import utilities.ReadExcelData;

public class DetailReport extends BaseClass {
	
	private static Logger log = LogManager.getLogger(DetailReport.class);
	DetailReportPage drp;
	@BeforeClass
	public void reportsModule()
	{
	    log.info("Navigation to report module");
		drp = new DetailReportPage(driver);
		drp.clickdetailreportmodule()
		   .clicksubmodulereport();
		log.info("Navigated to report module");
	}
	
	@Test
	public void detailReportGenerate() throws IOException
	{
		String downloadpath = System.getProperty("user.dir") + "\\Downloads\\DetailReport.zip";
		ExistingFileDelete.deleteFileIfExists(downloadpath);
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","Reports");
		drp.selectproducttype(red.getCellData(1, 0).trim())
		   .selectfromdateicon()
		   .setfromdate(red.getCellData(1, 1).trim())
		   .selecttodateicon()
		   .settodate(red.getCellData(1, 2).trim())
		   .submit()
		   .csvdownload();
		
	}
	

}
