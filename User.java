import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String phone;
    private Date birthdate;
    // constructor
    public User(){

    }

    // getters and setters
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public Date getBirthDate(){
        return this.birthdate;
    }
    public void setBirthDate(Date birthdate){
        this.birthdate = birthdate;
    }

}
