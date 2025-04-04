package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
public String readDataFrompFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream(IConstantUtility.propertyfilepath);
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
}
}
