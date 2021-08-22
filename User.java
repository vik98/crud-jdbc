package javaapplication181;

public class User {

    private int user_id;
    private String firstname;
    private String lastname;
    private String email;

    public User() {
        this.user_id = 0;
        this.firstname = "";
        this.lastname = "";
        this.email = "";
    }

    public User(int user_id, String firstname, String lastname, String email) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + '}';
    }

}
