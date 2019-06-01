package data;

public class User {
    int id;
    int levelAccess;
    String name;
    String password;
    UserAccess userAccess;

    public User(int id, int levelAccess, String name, String password) {
        this.id = id;
        this.levelAccess = levelAccess;
        this.name = name;
        this.password = password;
    }

    public void setUser(User user) {
        this.id = user.id;
        this.levelAccess = user.levelAccess;
        this.name = user.name;
        this.password = user.password;
    }

    @Override
    public String toString() {
        return String.format("%4d|%1d|%15s|%15s", id, levelAccess, name, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevelAccess() {
        return levelAccess;
    }

    public void setLevelAccess(int levelAccess) {
        this.levelAccess = levelAccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccess getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(UserAccess userAccess) {
        this.userAccess = userAccess;
    }
}
