/**
 * 
 */
package com.rest.main.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rest.main.domain.AppreciationPost;
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
    		,@RequestParam(value="password") String password,@RequestParam(value="sex") String sex,@RequestParam(value="city") String city) throws SQLException {
        return userService.registerUser(fullName,emailAddress,phoneNumber,password,sex,city);
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
	
	@RequestMapping(value="/getUserById" , method=RequestMethod.GET)
    public User getUserById(@RequestParam(value="userId") String userId) throws SQLException {
        return userService.getUserById(userId);
    }
	
	@RequestMapping(value="/addConnection" , method=RequestMethod.GET)
    public String addConnection(@RequestParam(value="requesterId") Long requesterId
    		,@RequestParam(value="acceptorId") Long acceptorId) throws SQLException {
        return userService.addConnection(requesterId,acceptorId);
    }
	
	
	@RequestMapping(value="/saveUser" , method=RequestMethod.GET)
    public String saveUser(@RequestParam(value="user") String userString) throws SQLException {
		Gson gson = new Gson();
		User user = gson.fromJson(userString, User.class);
		user.setFullName(user.getFullName().replace( "%20"," "));
        return userService.saveUser(user);
    }
	
	@RequestMapping(value="/getUserConnections" , method=RequestMethod.GET)
    public List<User> getUserConnections(@RequestParam(value="userId") Long userId) throws SQLException {
		
        return userService.getAllUserConnectionsOfUser(userId);
    }
	
	
	@RequestMapping(value="/getAllUsers" , method=RequestMethod.GET)
    public List<User> getAllUsers() throws SQLException {
        return userService.getAllUsers();
    }
	
	@RequestMapping(value="/savePost" , method=RequestMethod.GET)
    public String savePost(@RequestParam(value="post") String postStr) throws SQLException {
		Gson gson = new Gson();
		AppreciationPost post = gson.fromJson(postStr, AppreciationPost.class);
		AppreciationPost savedPost = userService.savePost(post);
		
        return gson.toJson(savedPost, AppreciationPost.class);
    }
	
	@RequestMapping(value="/getAppreciationsPosted" , method=RequestMethod.GET)
    public String getAppreciationsPosted(@RequestParam(value="user") String user) throws SQLException {
		Gson gson = new Gson();
		User userPosted = gson.fromJson(user, User.class);
		List<AppreciationPost> appreciationsPosted = userService.findAllBySenderId(userPosted);
		
        return gson.toJson(appreciationsPosted, new TypeToken<List<AppreciationPost>>(){}.getType());
    }
	
	@RequestMapping(value="/getAppreciationsReceived" , method=RequestMethod.GET)
    public String getAppreciationsReceived(@RequestParam(value="user") String user) throws SQLException {
		Gson gson = new Gson();
		User userPosted = gson.fromJson(user, User.class);
		List<AppreciationPost> appreciationsPosted = userService.findAllByReceiverId(userPosted);
		
        return gson.toJson(appreciationsPosted, new TypeToken<List<AppreciationPost>>(){}.getType());
    }
	
	@RequestMapping(value="/findPost" , method=RequestMethod.GET)
    public String findPost(@RequestParam(value="postId") Long postId) throws SQLException {
		Gson gson = new Gson();
		
		AppreciationPost savedPost = userService.findByPostId(postId);
		
        return gson.toJson(savedPost, AppreciationPost.class);
    }
	
	
	
	
	
}
