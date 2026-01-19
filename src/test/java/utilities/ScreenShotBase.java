package utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.BaseClass;

public class ScreenShotBase  extends BaseClass{
	
	public void getScreenShot(String packageName, String className, String methodName) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
	    String fileName = packageName + "_" + className + "_" + methodName + "_" + timestamp + ".jpeg";
	    String workspace = System.getProperty("user.dir");
	    File screenshotDir = new File(workspace, "screenshot"); 
	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdirs(); 
	    }
		File screenshotfile = ((TakesScreenshot) obj).getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotDir, fileName); // correct!
		FileUtils.copyFile(screenshotfile, destFile);
	}

}
