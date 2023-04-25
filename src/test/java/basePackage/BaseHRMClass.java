package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {
  public static Properties prop=new Properties();
  public static WebDriver driver;
  //step 1
  
  public BaseHRMClass() {
	  try {
	  FileInputStream file=new FileInputStream("C:\\Users\\Selvaraha\\eclipse-workspace\\HRManagement\\src\\test\\java\\environmentvariables\\Config.properties");
	 prop.load(file);
	  
  }
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException a) {
		a.printStackTrace();
	}
	  
  }
  //step 2 
  public static void initiate() 
  {
	  String browsername=prop.getProperty("browser");
	  
	  
	  
	  if(browsername.equals("Firefox")) {
		  System.getProperty("webdriver.gecko.driver","geckodriver.exe");
	  driver= new FirefoxDriver();
	  }
	  else if(browsername.equals("chrome")) {
		  System.getProperty("webdriver.chrome.driver","chromedriver.exe");
		  ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
		  driver= new ChromeDriver(op);
		  
		  
		  
	  }
	  driver.manage().window().maximize();
	  // driver.manage().timeouts().implicitlyWait(TimeUtils.timepage);
	  // driver.manage().timeouts().implicitlyWait(TimeUtils.timepage, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
	  driver.get(prop.getProperty("url"));
	  
  }
  public static void screenshots(String Filename) {
	  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
	  
	  FileUtils.copyFile(file, new File("C:\\Users\\Selvaraha\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg" ));
	  }
	  catch (IOException e) {
		  e.printStackTrace();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
}
  

