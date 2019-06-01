package data;

public enum UserAccess {
    Head,
    Managment,
    Other,
    NoAccess;

    static public UserAccess getAccess(int access){
        switch (access){
            case -1: return Head;
            case -2: return Managment;
            case 0: return NoAccess;
        }
        return Other;
    }
}
