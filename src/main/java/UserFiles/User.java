package UserFiles;

public class User {
    String name;
    private String id;
    private String email;
    private String password;
    private String[] courses;

    public User(String name, String id, String email, String password, String[] courses){
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.courses = courses;
    }

    public boolean validateLogin(String email, String password){
        return this.email.equals(email) && this.password.equals(password);
    }

    public String getName(){return name;}
    public String getID(){return id;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String[] getCourses(){ return courses;}
}
