package com.revature.controllers;


import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.models.Account;
import com.revature.models.Account.AccountType;
import com.revature.services.AccountService;
import com.revature.models.UserDTO;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







public class AccountController extends Controller {
    private final Logger log = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService = new AccountService();

    public AccountController() {}
    private final Handler getAllAccounts = ctx -> {
        if (ctx.req.getSession(false) != null) {

            Account a = (Account) ctx.req.getSession().getAttribute("user");

            // Only administrators can view all
            if (a != null && a.getAccountType() == AccountType.MANAGER) {

                ArrayList<Account> list = accountService.getAllAccounts();

                ctx.json(list);
                ctx.status(200);
            } else {
                ctx.html("NOT_MANAGER");
                ctx.status(401);
            }
        } else {
            ctx.html("NOT_LOGGED_IN");
            ctx.status(401);
        }
    };
    private final Handler addAccount = ctx -> {
        if (ctx.req.getSession(false) != null) {
            ctx.html("LOGGED_IN");
            ctx.status(400);
            log.info("NEED to be logged out");
        } else {
            Account a = ctx.bodyAsClass(Account.class);
            switch (accountService.saveAccount(a)) {
                case SUCCESS:
                    Account new_user = accountService.getAccountByEmail(a.getEmail());
                    ctx.json(new_user);
                    ctx.req.getSession().setAttribute("user", new_user);
                    ctx.status(201);
                    log.info("Succefully registered: " + a.getEmail());
                    break;
                case ERROR:
                    ctx.html("<h1> Error Creating Account: First or Last Name Can't be Empty </h1>");
                    ctx.status(400);
                    log.warn("user tried registering with invalid empty first or last name: " + a);
                    break;

                default:
                case TRY_AGAIN:
                    ctx.html("<h1> There was a mistake try again please </h1>");
                    log.error("Error creating account => " + a);
                    ctx.status(400);
                    break;
            }
        }
    };
    private final Handler updateAccount = ctx -> {
        if (ctx.req.getSession(false) != null) {
            Account a = (Account) ctx.req.getSession().getAttribute("user");
            UserDTO info = ctx.bodyAsClass(UserDTO.class);
            a.setFirstName(info.firstName);
            a.setLastName(info.lastName);
            a.setEmail(info.email);
            a.setPassword(info.password);
            switch (accountService.updateAccount(a)) {
                case SUCCESS:
                    Account customer = accountService.getAccountByEmail(a.getEmail());
                    ctx.json(customer);
                    ctx.status(200);
                    log.info("Updated: " + customer.getEmail());
                    break;
                case INVALID:
                    ctx.html("<h1> Try Again </h1>");
                    ctx.status(400);
                    log.warn("Email error: " + a.getEmail());
                    break;
                default:
                case TRY_AGAIN:
                    ctx.html("<h1> ERROR </h1>");
                    log.error("Try again : " + a);
                    ctx.status(400);
                    break;
            }
        } else {
            ctx.html("NOT_LOGGED_IN");
            ctx.status(401);
            log.warn("need to log in please");
        }
    };
    private final Handler getAccountById = ctx -> {
        if (ctx.req.getSession(false) != null) {
            Account a = (Account) ctx.req.getSession().getAttribute("user");
            if (a != null && a.getAccountType() == AccountType.MANAGER) {
                String pathId = ctx.pathParam("id");
                int id = Integer.parseInt(pathId);
                Account user = accountService.getAccountById(id);

                if (user != null) {
                    ctx.json(user);
                    ctx.status(200);
                } else {
                    log.warn("ERROR:");
                    ctx.status(400);
                }
            } else {
                ctx.status(401);
                log.warn("ERROR");
            }
        } else {
            ctx.status(401);
            log.warn("User tried to delete someone without being logged in");
        }
    };
    private final Handler getAccount = ctx -> {
        if (ctx.req.getSession(false) != null) {

            Account a = (Account) ctx.req.getSession().getAttribute("user");

            if (a != null) {
                Account user = accountService.getAccountByEmail(a.getEmail());
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
        app.put("/account", updateAccount);
        app.post("/register", addAccount);
        app.get("/accounts", getAllAccounts);
        app.get("/account/view/{id}", getAccountById);


    }
}
