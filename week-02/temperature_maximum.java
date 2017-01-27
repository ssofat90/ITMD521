
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class temperature_maximum {
	

	
	private static final String TEMP_TABLE = "create table temperature ( "
		      + "   year INT , temperature INT )";
	private static final String DROP_TABLE = "DROP TABLE temperature ";
	private static final String TRUNCATE_TABLE = "TRUNCATE temperature ";
	private static final String  INSERT_TEMPERATURE_TABLE = "insert into temperature(year, temperature) values(?,?)";
	private static final String  QWERY_MAX_TEMPERATURE_TABLE = "select year, max(temperature) from temperature where temperature!=9999 group by year";
	//CHANGE PATH HERE
	private static final String DIRECTORY = "C:\\Users\\Saahil\\vagrant_getting_started\\trusty64\\all\\1990.gz";
	static Connection connection = null;
	static Statement stmt = null;
	public static void main(String [] args) throws IOException {
		
		//Connect to DB
		//establishConnection();
		
		File f = null;
	      String[] paths;
	            
	      try{      
	         // create new file
			 
	         f = new File(DIRECTORY);
	         System.out.println("hi");                        
	         // array of files and directory
	         paths = f.list();
			 System.out.println("hi2");
             System.out.print(paths);
	         // for each name in the path array
	         for(String path:paths)
	         {
		System.out.println("kill");
	            // prints filename and directory name
	            System.out.println(">>>>>>>>> "+path);
	            File file = new File(DIRECTORY+"/"+path);

	    		try {
	    			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	    			//File is found
	    				System.out.println("File Found : " + file.exists());
	    				//Read File Content
 	    				String content = new String(Files.readAllBytes(file.toPath()));
 	    				int year = Integer.parseInt(content.substring(15,19));
 	    				int  temp = Integer.parseInt(content.substring(87,92)); 
 	    			
 	    				System.out.println("****************");
 	    				System.out.println("year = "+ year);	
 	    				System.out.println("Temp = "+ temp);	
 	    				System.out.println("****************");
 	    				
 	 	    				//stmt.executeUpdate("insert into temperature(year, temperature) values("+year+","+temp+")");
 	 	    				System.out.println("Successfully  inserted data");
 	 	    		      //stmt.executeUpdate("insert into temperature(year, temperature) values("+c1+","+c2+")");
 	 	    		      //connection.commit();
     

	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	            
	         }
	         
 			//QWERY TABLE FOR MAX TEMP AND YEARS
				ResultSet rs = stmt.executeQuery(QWERY_MAX_TEMPERATURE_TABLE);
				while (rs.next()) {
					  int tableYear = rs.getInt("year");
					  int tableTemp = rs.getInt("max(temperature)");
					  System.out.println("Final output");
					  System.out.println("tableYear ="+ tableYear+ "\n"+"tableTemp ="+ tableTemp );
					  	
				}

		          stmt.close();
		          connection.close();
	         
	         
	      }catch(Exception e){
	         // if any error occurs
	         e.printStackTrace();
	      }
	
}
	private static void establishConnection() {
		// TODO Auto-generated method stub

  		try{
  			// DB CREDENTIALS
  		connection = DriverManager.getConnection("jdbc:mysql://localhost","root", "safestsystemever");
			connection.setAutoCommit(false); 
			System.out.println("MySQL JDBC Driver Registered!");
			stmt = connection.createStatement();
			 // DROP TABLE
			 stmt.executeUpdate(DROP_TABLE);
			 System.out.println("Dropped temperature table");
			 //CREATE TABLE
			 stmt.executeUpdate(TEMP_TABLE);
			 System.out.println("temperature table created.");
		     //TRUNCATE TABLE
			 stmt.executeUpdate(TRUNCATE_TABLE);
			 System.out.println("truncated temperature table");
			 
	}catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
}
  		

