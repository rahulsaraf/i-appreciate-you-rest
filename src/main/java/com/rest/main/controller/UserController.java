/**
 * 
 */
package com.rest.main.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.main.domain.User;
import com.rest.main.service.UserService;

/**
 * @author rahul
 *
 */

@RestController
public class UserController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
    public String registerUser(@RequestParam(value="fullName") String fullName,@RequestParam(value="emailAddress") String emailAddress
    		,@RequestParam(value="phoneNumber") String phoneNumber
    		,@RequestParam(value="password") String password) throws SQLException {
        return userService.registerUser(fullName,emailAddress,phoneNumber,password);
    }
	
	@RequestMapping("/hello")
    public String display() throws SQLException {
        return "hello";
    }
	@RequestMapping(value="/login" , method=RequestMethod.GET)
    public String loginUser(@RequestParam(value="emailAddress") String emailAddress
    		,@RequestParam(value="password") String password) throws SQLException {
        return userService.loginUser(emailAddress,password);
    }
	
	@RequestMapping(value="/getUser" , method=RequestMethod.GET)
    public User getUser(@RequestParam(value="emailAddress") String emailAddress) throws SQLException {
        return userService.getUser(emailAddress);
    }
	
	@RequestMapping(value="/addConnection" , method=RequestMethod.GET)
    public String addConnection(@RequestParam(value="requesterId") Long requesterId
    		,@RequestParam(value="acceptorId") Long acceptorId) throws SQLException {
        return userService.addConnection(requesterId,acceptorId);
    }
	
	
	
	
}
