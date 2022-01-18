package com.revature.controllers;
import com.revature.models.Employee;
import io.javalin.core.security.RouteRole;

public enum Role implements RouteRole{
    Customer,
    Employee,
    Manager,
}
