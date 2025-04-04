package vtiger.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
public static void main(String[] args) throws IOException {
	//load the file file input stream
	FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
	//create object of properties from java
	Properties pobj=new Properties();
	
	//load the file to properties obj
	pobj.load(fis);
	//read the data through the key
	String BROWSER = pobj.getProperty("browser");
	System.out.println(BROWSER);
	String URL = pobj.getProperty("url");
	System.out.println(URL);
}
}
