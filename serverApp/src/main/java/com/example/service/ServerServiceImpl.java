package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Server;

@Service
public class ServerServiceImpl implements ServerService {

	private static List<Server> servers;

	static {
		servers = populateDummyServers();
	}

	@Override
	public Server findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveServer(Server server) {
		servers.add(server);

	}

	@Override
	public void updateUser(Server server) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteServerById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Server> findAllServers() {
		// TODO Auto-generated method stub
		return servers;
	}

	@Override
	public void deleteAllServers() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isServerExist(Server server) {
		// TODO Auto-generated method stub
		return false;
	}

	private static List<Server> populateDummyServers() {
		List<Server> servers = new ArrayList<Server>();

		servers.add(new Server("server", 1, 101));
		servers.add(new Server("server1", 2, 102));
		servers.add(new Server("server2", 3, 103));

		return servers;
	}

}
