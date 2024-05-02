package oracle.function;


public class UserInfo {
    private String userId;
    private String passwd;
    private String userType;
    private String name;

    public UserInfo() {
    }

    public UserInfo(String userId, String passwd, String userType, String name) {
        this.userId = userId;
        this.passwd = passwd;
        this.userType = userType;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
