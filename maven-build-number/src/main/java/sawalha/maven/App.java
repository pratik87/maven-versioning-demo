package sawalha.maven;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import java.util.Properties;

public class App {
    
	private static Properties properties = new Properties();
    
	public static void main(String[] args) throws IOException {
        // Check Manifest file based on generated build number
        Manifest mf = new Manifest();
        mf.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/MANIFEST.MF"));

        Attributes atts = mf.getMainAttributes();

		System.out.println("**********************************************************");
        System.out.println("META-INF/MANIFEST.MF [Implementation-Versio]: " + atts.getValue("Implementation-Version"));
        System.out.println("META-INF/MANIFEST.MF [Implementation-Build]: " + atts.getValue("Implementation-Build"));
        System.out.println("**********************************************************");
        System.out.println("version.properties [version]:" + getApplicationVersion().get("version"));
        System.out.println("version.properties [build.no]:" + getApplicationVersion().get("build.no"));
        System.out.println("version.properties [build.date]:" + getApplicationVersion().get("build.date"));
		System.out.println("**********************************************************");
		System.out.println("Finished.");

    }
	
	public static Properties getApplicationVersion() {
        try {
            properties.load(App.class.getResourceAsStream("/version.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
