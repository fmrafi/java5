package training;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Helloi18n {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("training.messages");
		// if specified in the command line load the Locale specific bundle
		if (args.length > 0) {
			bundle = ResourceBundle.getBundle("training.messages", 
                                new Locale(args[0]));
		}
		String country_prop = "user.country";
		String language_prop = "user.language";
		Properties props = System.getProperties();
		System.out.println(country_prop + ": " + props.getProperty(country_prop)); 
		System.out.println(language_prop + ": " + props.getProperty(language_prop));
                
                System.out.println("Note: You may specify the default language of JVM at startup using system property e.g. -Duser.language=bn");
                
		System.out.println("say hello: " + bundle.getString("welcome"));
                System.out.println("say bye: " + bundle.getString("goodbye"));
	}

}
 