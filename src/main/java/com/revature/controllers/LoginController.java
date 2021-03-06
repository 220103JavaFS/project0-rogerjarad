package com.revature.controllers;


import com.revature.models.UserDTO;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.services.LoginService;
import static com.revature.models.EncryptionSHA.getSHA;
import static com.revature.models.EncryptionSHA.toHexString;

public class LoginController implements Controller {
    private final Logger log = LoggerFactory.getLogger(LoginController.class);



    LoginService loginService = new LoginService();
    private Handler loginAttempt = (ctx) -> {
        UserDTO userDTO = ctx.bodyAsClass(UserDTO.class);
        userDTO = loginService.Login(userDTO.username, toHexString(getSHA(userDTO.password)));
        if(userDTO != null){
            ctx.req.getSession().setAttribute("accountType", userDTO.accountType);
            ctx.html("<h1> LOGGED_IN </h1>");
            ctx.status(200);
        }else {
            ctx.req.getSession().invalidate();
            ctx.status(401);
            ctx.html("<h1> LOGGED_IN </h1>");
        }



    };



    //    private Handler loginAttempt = (ctx) -> {
//        UserDTO userDTO = ctx.bodyAsClass(UserDTO.class);
//
//        if(loginService.login(userDTO.username, userDTO.password))
//        {
//            ctx.req.getSession();
//            ctx.status(200);
//        }else
//        {
//            ctx.req.getSession().invalidate();
//            ctx.status(401);
//        }
//    };
//
//
    private final Handler endSession = ctx -> {
        if (ctx.req.getSession(false) != null) {
            ctx.req.getSession().invalidate();
            ctx.status(200);
            ctx.html("<h1> LOGGED_OUT </h1>");
            log.info("User Logged out");
        } else {
            ctx.html("<h1> PLEASE_LOG_IN </h1>");
        }
    };


    @Override
    public void addRoutes(Javalin app) {

        app.post("/login", loginAttempt);
        app.post("/logout", endSession);

    }
}