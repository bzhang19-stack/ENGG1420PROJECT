package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class Events {
    private String code;
    private String name;
    private String description;
    private String location;
    private String dateAndTime;
    private int capacity;
    private String cost;
    private String headerImage;
    private String[] registeredStudents;

    private static List<Events> allEvents = new ArrayList<>();

    public Events(String code, String name, String description, String location, String dateAndTime, int capacity, String cost, String headerImage, String[] registeredStudents){
        this.code = code;
        this.name = name;
        this.description = description;
        this.location = location;
        this.dateAndTime = dateAndTime;
        this.capacity = capacity;
        this.cost = cost;
        this.headerImage = headerImage;
        this.registeredStudents = registeredStudents;
    }

    public String getCode(){return code;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getLocation(){return description;}
    public String getDateAndTime(){return dateAndTime;}
    public int getCapacity(){return capacity;}
    public String getCost(){return cost;}
    public String getHeaderImage(){return headerImage;}
    public String[] getRegisteredStudents(){return registeredStudents;}

    public static void initializeEvents(){

        CSVImport importer = new CSVImport(); // Create an instance of CSVImport
        List<String[]> eventsData = importer.getCSVData("UMS_Data(Events ).csv"); // Call the method on the instance

        if (eventsData.isEmpty()) {
            System.out.println("⚠️ No event data found in CSV.");
            return;
        }

        for (String[] data : eventsData) {

            if(data.length==0) break; //Stops when there are no more students

            String code = data[0].trim();
            String name = data[1].trim();
            String description = data[2].trim();
            String location = data[3].trim();
            String dateAndTime = data[4].trim();
            int capacity = Integer.parseInt(data[5].trim());
            String cost = data[6].trim();
            String headerImage = data[7].trim();
            String registeredStudents = data[8].trim();


            String students[] = registeredStudents.split(",");

            for(int i=0; i< students.length; i++)
                students[i] = students[i].trim();

            allEvents.add(new Events(code,name,description,location,dateAndTime,capacity,cost,headerImage,students));
        }
        System.out.println("✅ Successfully loaded " + allEvents.size() + " events from CSV.");
    }
}
