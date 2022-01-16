package com.revature.controllers;

import com.revature.models.UserDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LoginController implements Controller{

    LoginService loginService = new LoginService();

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
