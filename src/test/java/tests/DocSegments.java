package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.DocSegmentsPage;
import pages.LoginPage;

public class DocSegments extends BaseClass{
	
	private static Logger log = LogManager.getLogger(DocSegments.class);
	LoginPage loginobj;
	
	DocSegmentsPage docseg;
	@BeforeClass
	public void verifyDocSegmentssetup() throws IOException {
		log.info("Documents Segments link Click");
		docseg = new DocSegmentsPage(obj);
	}
	
	@Test(priority=1)
	@Description("Verify that New Document Segment can be Added successfully")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyAddDocSeg() throws InterruptedException {
		
		log.info("The Document segment add started ");
		boolean add_doc_success =  docseg.addDocSegment();
		Assert.assertTrue(add_doc_success,"Doc Segment was not added successfully");
		Thread.sleep(2000);
	}
	
	
	@Test(priority=2)
	@Description("Verify that New Document Segment can be Viewed successfully")
	@Severity(SeverityLevel.NORMAL)
	public void verifyViewDogSeg() throws InterruptedException
	{
		log.info("View Segement Method Called");
		boolean view_doc_success = docseg.viewDocSegement();
		Assert.assertTrue(view_doc_success,"Doc Segement Was Not viewed Successfully");
		
	}
	@Test(priority=3,enabled=true)
	@Description("Verify that New Document Segment can be Edited successfully")
	@Severity(SeverityLevel.NORMAL)
	public void verifyEditDogSeg() throws InterruptedException
	{
		log.info("Edit Segement Method Called");
		boolean edit_doc_success = docseg.editDocSegement();
		Assert.assertTrue(edit_doc_success,"Doc Segement Was Not Edited Successfully");
		
	}
	@Test(priority=4,enabled=true)
	@Description("Verify that New Document Segment can be Deleted successfully")
	@Severity(SeverityLevel.NORMAL)
	public void verifyDeleteDogSeg() throws InterruptedException
	{
		log.info("Delete Segement Method Called");
		boolean delete_doc_success = docseg.deleteDocSegement();
		Assert.assertTrue(delete_doc_success,"Doc Segement Was Not Deleted Successfully");
		
	}
}
