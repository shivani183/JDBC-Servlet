package new1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Launch1 {

	public static void main(String[] args) throws Exception {
		FileInputStream fis= new FileInputStream("/Users/avinashsingh/eclipse-workspace_2022/Properties_obj/src/new1/application.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String url=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String passWord=properties.getProperty("passWord");
		
		System.out.println(url);
		System.out.println(userName);
		System.out.println(passWord);

	}

}
