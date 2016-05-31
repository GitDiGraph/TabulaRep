package gui;

import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class JVMEnvironment {
	// A few application constant
			public final String GRAPH_DIRECTORY="DiGraph";
			public final String GRAPH_SYSTEM_DIRECTORY="DiGraphSys";
			public final String GRAPH_USER_DIRECTORY="DiGraphUser";
			public final String GRAPH_DEFAULT_PREFERENCES="DefaultPref.pf";
			
			//a few usefull system properties
			private String userName;
			private String userCountry;
			private String userLanguage;
			private String systemLocale;
			private String userHome;
			public String osName;
			public String javaVersion;
			private String userDirectory;
			public String fileSeparator;
			public String pathSeparator;
			public String DiGraphPath;
			public String DiGraphUserPath;
			
			public String[] pred;
			public String rootU=null;
			
			

		String[] propertyNames;	
		String[] value;
		/*
		 * Class constructor:	retrieve and print 
		 */
		public JVMEnvironment(){
			 
		   //print heap and memory info
			 System.out.println("\n ----------------print heap and memory  info \n"); 
		    int mb = 1024*1024;
		    //Getting the runtime reference from system
		    Runtime runtime = Runtime.getRuntime();
		    System.out.println("##### Heap utilization statistics [MB] #####");
		    //Print used memory
		    System.out.println("Used Memory:"
		        + (runtime.totalMemory() - runtime.freeMemory()) / mb);
		    //Print free memory
		    System.out.println("Free Memory:"
		        + runtime.freeMemory() / mb);
		    //Print total available memory
		    System.out.println("Total Memory:" + runtime.totalMemory() / mb);
		    //Print Maximum available memory
		    System.out.println("Max Memory:" + runtime.maxMemory() / mb);
		    
			Properties systemProps = System.getProperties();
			
			  System.out.println("\n ------------------ print JVM and system related system properties \n");
			Set<Entry<Object, Object>> sets=systemProps.entrySet();
			System.out.println("System Properties");
			for (Entry<Object, Object> entry : sets){
				System.out.printf("%-30s %-50s\n",  entry.getKey(), entry.getValue() );
			}
			getLocal();
			envSetup();    
		}
		public void getLocal(){	
			 System.out.println("\n ------------------ print locale and language information \n");
			Locale locale =null;
			locale=Locale.getDefault();
			System.out.println("System locale= "	+locale);
			String names=locale.getDisplayName(locale);
			System.out.println(" System locale language + country= "	+names);
			return;
			    }	 
		public void envSetup(){
			 System.out.println("\n ---------save a few information for future use file system and directory information \n");
				String value;
				try {
			       userHome = System.getProperty("user.home");
			       System.out.println("userHome = "+userHome);
			              
			       userName=System.getProperty("user.name");
			       System.out.println("userName = "+userName);
			       
			       userCountry=System.getProperty("user.contry");
			       System.out.println("userCountry = "+userCountry);
			       
			       userLanguage=System.getProperty("user.language");
			       System.out.println("userLanguage = "+userLanguage);
			       
			       systemLocale=System.getProperty("system.locale");
			       System.out.println("systemLocale = "+systemLocale);
			       
			       osName=System.getProperty("os.name");
			       System.out.println("osName = "+osName);
			       
			       javaVersion=System.getProperty("java.version");
			       System.out.println("javaVersion = "+javaVersion);
			       
			       userDirectory=System.getProperty("user.dir");
			       System.out.println("userDirectory = "+userDirectory);
			       
			       fileSeparator=System.getProperty("file.separator");
			       System.out.println("fileSeparator = "+fileSeparator);
			    
			       pathSeparator=System.getProperty("path.separator");
			       System.out.println("pathSeparator = "+pathSeparator);
			       
			      } catch (SecurityException e) {
			    	  System.out.println(" cannot read user.home value= ");  
			    	 
			      }	
				//check for java version and other environment inconsistencies
				System.out.println("************************************************** pass 1");
				  if((!javaVersion.substring(0,3).equals("1.7"))&&(!javaVersion.substring(0,3).equals("1.8"))) 
				  {
					  System.out.println("Wrong java environment:"+javaVersion+" not supported");
					  System.exit(0);
				  }   
				  System.out.println("************************************************** pass 1");
	}
}
