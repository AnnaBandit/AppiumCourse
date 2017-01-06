package models;

public class User {

    private String username;
    private String email;
    private String password;
    private String name;
    private String programmingLanguage;
    private boolean acceptAdds;

    public User(String username, String email, String password, String name, String programmingLanguage, boolean acceptAdds){
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.programmingLanguage = programmingLanguage;
        this.acceptAdds = acceptAdds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public boolean isAcceptAdds() {
        return acceptAdds;
    }

    public void setAcceptAdds(boolean acceptAdds) {
        this.acceptAdds = acceptAdds;
    }


}
