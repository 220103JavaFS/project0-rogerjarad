package com.revature.controllers;


import com.revature.models.Login;
import com.revature.models.UserDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class LoginController extends Controller{

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService = new LoginService();

    public LoginController()  {}


    private Handler getAllLogin = ctx -> {
        ArrayList<Login> list = loginService.getAllLogin();
        ctx.json(list);
        ctx.json(200);
    };

    private Handler loginAttempt = (ctx) -> {
        UserDTO userDTO = ctx.bodyAsClass(UserDTO.class);

        if(loginService.login(userDTO.username, userDTO.password))
        {
            ctx.req.getSession();
            ctx.status(200);
        }else
        {
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }
    };




    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginAttempt);
    }

}
