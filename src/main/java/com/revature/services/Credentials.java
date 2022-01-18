package com.revature.services;
import com.revature.MyExc.Except;
import com.revature.controllers.Role;


public final class Credentials {

    private static String cred;


    public Credentials(){}

    private static String typed;

    static boolean isCredName(String name){
        typed = "[A-za-z]";
        if(!name.matches(typed)) {
            System.out.println("Try again");
        }
        return true;

        }

    static boolean isCredEmail(String email) {
        typed = "[A-Za-z]{1,32}([A-Za-z]|[0-9]){0,32}@[A-Za-z]{1,121}([A-Za-z]|[0-9]){0,121}.[a-z]{3}";
        if (!email.matches(typed)) {
            System.out.println("Try again");
        }
        return true;

    }

    public static boolean isCredRole(String roletype){
        Role[] roles = Role.values();
        boolean isRoles = false;
        for(Role r: roles){
            if(roletype.equalsIgnoreCase(r.toString())){
                isRoles = true;

            }
        }


        return true;
    }




}
