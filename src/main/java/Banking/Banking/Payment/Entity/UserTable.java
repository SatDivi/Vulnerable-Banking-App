package Banking.Banking.Payment.Entity;

import jakarta.persistence.*;

import static jakarta.persistence.EnumType.*;

public class UserTable {

    @Column
    private String userName;


    @Column
    private String Password;

    @Column @Enumerated(EnumType.STRING)
    private UserType Type;
    public enum UserType{
        Admin,
        User
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public UserType getType() {
        return Type;
    }

    public void setType(UserType type) {
        Type = type;
    }
}

