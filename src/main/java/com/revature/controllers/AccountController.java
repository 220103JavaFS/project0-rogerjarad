package com.revature.controllers;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.models.Account;
//import com.revature.models.Account.AccountType;
import com.revature.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







public class AccountController implements Controller {
    private final Logger log = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService = new AccountService();



    Handler updateAccount = (ctx) ->{
        Account account = new Account();

        account = ctx.bodyAsClass(Account.class);
        System.out.println(account);

        if(ctx.req.getSession(false) != null) {
            ctx.json(accountService.updateAccount(account));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    public AccountController() {}
    private Handler getAllAccounts = ctx -> {
        if (ctx.req.getSession(false) != null) {
            ctx.json(accountService.getAllAccounts());
            ctx.status(200);

        }else {
            ctx.status(401);
        }

    };
    private final Handler addAccount = ctx -> {
        if (ctx.req.getSession(false) != null) {
            Account account = ctx.bodyAsClass(Account.class);
            if(accountService.addAccount(account)){
                ctx.status(201);

            }else {
                ctx.status(400);

            }

        }else {
            ctx.status(401);
        }
    };

    private final Handler getAccountByFirstName = ctx -> {
        if (ctx.req.getSession(false) != null) {
            String first_name = ctx.pathParam("first_name");

            Account account = accountService.getAccountByFirstName(first_name);
            ctx.json(account);
            ctx.status(200);

        }else{
            ctx.status(400);
        }

    };

    private final Handler getAccountById = ctx -> {
        if (ctx.req.getSession(false) != null) {
            String idString = ctx.pathParam("id");
            int id = Integer.parseInt(idString);
            Account account = accountService.callId(id);
            ctx.json(account);
            ctx.status(200);

        }else{
            ctx.status(400);
        }

    };

    private final Handler getAccount = ctx -> {
        if (ctx.req.getSession(false) != null) {

            Account a = (Account) ctx.req.getSession().getAttribute("user");

            if (a != null) {
                Account user = accountService.getAccountByUsername(a.getUsername());
                if (user != null) {
                    ctx.json(user);
                    ctx.status(200);
                    log.info("View account " + a);
                }
            }
        } else {
            ctx.status(401);
            log.warn("ERROR");
        }
    };










    @Override
    public void addRoutes(Javalin app) {
        app.get("/account", getAccount);
        app.put("/upaccount", updateAccount);
        app.post("/register", addAccount);
        app.get("/accounts", getAllAccounts);
        app.get("/account/{id}", getAccountById);
        app.get("/account/first/{first_name}", getAccountByFirstName);


    }
}