package hw6.Entity;

import java.util.Objects;

public class UserTable {
    private String Number;
    private String User;
    private String Description;

    public UserTable() {
    }

    public UserTable(String numberType, String user, String description) {
        this.Number = numberType;
        this.User = user;
        this.Description = description;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }



    @Override
    public String toString() {
        return "UserTable{" +
                "Number='" + Number + '\'' +
                ", User='" + User + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTable)) return false;
        UserTable userTable = (UserTable) o;
        return Objects.equals(getNumber(), userTable.getNumber()) &&
                Objects.equals(getUser(), userTable.getUser()) &&
                Objects.equals(getDescription(), userTable.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getUser(), getDescription());
    }
}

