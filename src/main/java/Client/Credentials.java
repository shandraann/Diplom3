package Client;

public class Credentials {
    private String email;
    private String password;

    public Credentials(UserModel user){
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public static Credentials from (UserModel user){
        return new Credentials(user);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}