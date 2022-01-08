package com.revature.People;

//Roger Gaulke

public class Users {
    private int user;
    private String userName;
    private String pw;
    private boolean emUser;

    public Users(){
        super();
    }

    public Users(String userName, String pw){
        super();
        this.userName = userName;
        this.pw = pw;
        this.user = user;
        this.emUser = false;
    }

    public Users(int user, String userName, String pw){
        super();
        this.user = user;
        this.userName = userName;
        this.pw = pw;
        this.emUser = false;

    }

    public void setEm(int emUser) {

    }
    public boolean isEmUser(){
        return emUser;
    }
    public void setEmUser(boolean emUser){
        this.emUser = emUser;
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
