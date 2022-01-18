package com.revature.controllers;

import com.revature.models.UserDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginController extends Controller{
    private final Logger log = LoggerFactory.getLogger(LoginController.class);

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

    private Handler logout = (ctx) -> {
        ctx.req.getSession().invalidate();
        ctx.status(200);
    };



    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginAttempt);
        app.post("/logout", logout);
    }
}
