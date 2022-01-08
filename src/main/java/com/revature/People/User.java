package com.revature.People;

//Roger Gaulke

public class User {
    private int user;
    private String userName;
    private String pw;
    private boolean superUser;

    public User(){
        super();
    }

    public User(String userName, String pw){
        super();
        this.userName = userName;
        this.pw = pw;
        this.user = user;
        this.superUser = false;
    }

    public User(int user, String userName, String pw){
        super();
        this.user = user;
        this.userName = userName;
        this.pw = pw;
        this.superUser = false;

    }

    public void setSuper(int superUser) {

    }
    public boolean isSuperUser(){
        return superUser;
    }
    public void setSuperUser(boolean superUser){
        this.superUser = superUser;
    }
    public int getUser(){
        return user;
    }
    public void setUser(int user){
        this.user = user;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getPw(){
        return pw;
    }
    public void setPw(String pw){
        this.pw = pw;
    }
    public String toString(){
        return "User ID is: " + user + " User Name is: " + userName + " The user password is: " + pw;
    }

}
