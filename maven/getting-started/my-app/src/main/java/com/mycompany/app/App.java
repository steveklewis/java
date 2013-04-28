package com.mycompany.app;

import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
	throws Exception
    {
	App app = new App();
	InputStream is = app.getInputStream();
	Properties props = new Properties();
	props.load(is);
	is.close();
	is = null;

	System.out.println(props.getProperty("message"));
    }

    public InputStream getInputStream()
    {
	InputStream is = getClass().getResourceAsStream("/application.properties");
	return is;
    }
}
