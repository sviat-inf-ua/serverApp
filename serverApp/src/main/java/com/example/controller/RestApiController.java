package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.model.Server;
import com.example.model.User;
import com.example.service.ServerService;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	UserService userService;
	
	@Autowired
	ServerService serverService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/servers", method = RequestMethod.GET)
	public ResponseEntity<List<Server>> listAllServers() {
		List<Server> servers = serverService.findAllServers();
		if (servers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Server>>(servers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
	//	logger.info("Creating User : {}", user);	
//
//		if (userService.isUserExist(user)) {
//		//	logger.error("Unable to create. A User with name {} already exist", user.getName());
//			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
//			user.getName() + " already exist."),HttpStatus.CONFLICT);
//		}
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/server", method = RequestMethod.POST)
	public ResponseEntity<?> createServer(@RequestBody Server server, UriComponentsBuilder ucBuilder) {
	//	logger.info("Creating User : {}", user);
//
//		if (userService.isUserExist(user)) {
//		//	logger.error("Unable to create. A User with name {} already exist", user.getName());
//			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
//			user.getName() + " already exist."),HttpStatus.CONFLICT);
//		}
		serverService.saveServer(server);
	//	userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/server/{id}").buildAndExpand(server.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
