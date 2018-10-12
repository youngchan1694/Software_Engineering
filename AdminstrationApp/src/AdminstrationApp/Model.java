/*
 * TODO:
 * getPeopleFromDatabase method needs to be implemented
 * WritePeopleToDatabse method needs to be implemented
 * readGroupsFromDatabase method needs to be implemented
 * writeGroupsToDatabase method needs to be implemented
 * writeResponseToCSV method needs to be implemented
 */
package AdminstrationApp;

import java.beans.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alewis91
 */

public class Model implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public ArrayList<Person> people;
    
    public ArrayList<Group> groups;
    
    public final String GET_USERS_URL = "http://emoji-survey.me/auth/users";
    
    private static final String USER_AGENT = "Mozilla/5.0";
    
    public Model() {
        propertySupport = new PropertyChangeSupport(this);
        getPeopleFromDatabase();
        ReadGroupsFromDatabase();
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    
    //This method is where the code that reads the people from the database and
    //loads each one into people objects that are stored as an arraylist.
    public void getPeopleFromDatabase() {
        
    }
    
    //This method writes all people with changed elements to the database
    public void writePeopleToDatabase() {
        
    }

    //This method goes to our local database and reads in all existing groups
    private void ReadGroupsFromDatabase() {
        
    }
    
    //This method writes changes to groups to the local database
    private void writeGroupsToDatabase(){
        
    }
    
    //This method uses the CSVUtils class to write response data to a CSV file.
    //For example on usage of CSVUtils class, see Sprint1/Tester/Research how data 
    //will be exported to CSV in the project github.
    public void writeResponseToCSV() {
        
    }
    
    public ArrayList getPeople()
    {
        return people;
    }
    
    
    
    public void testGetUsers() throws IOException
    {
        
        String token = "d9ed1ecac123cae16e6e1a0b565762786bef301f";
        URL obj = new URL(GET_USERS_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        String auth = "Token " + token;
        con.setRequestMethod("GET");
        con.setRequestProperty ("Authorization", auth);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
	     if (responseCode == HttpURLConnection.HTTP_OK) { // success
		BufferedReader in = new BufferedReader(new InputStreamReader(
		con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		    while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		    }
		in.close();

	        // print result
	        System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}
            
    } 
}
