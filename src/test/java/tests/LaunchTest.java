package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;

public class LaunchTest extends ProjectSpecificationMethods{

	@Test
    public void applicationShouldLaunch() {

	        driver.get(appUrl);

	        // If page loads without exception → PASS
	        String title = driver.getTitle();

	        Assert.assertNotNull(title, "Application loaded but page title is null");
	        System.out.println("Application launched successfully at " + appUrl);
	    
    }
}
