package com.example.service;

import java.util.List;

import com.example.model.Server;

public interface ServerService {

	Server findByName(String name);

	void saveServer(Server server);

	void updateUser(Server server);

	void deleteServerById(long id);

	List<Server> findAllServers();

	void deleteAllServers();

	boolean isServerExist(Server server);
}
