package es.api.docu.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import es.api.docu.webapp.dtos.User;

@Service
public class UserService {
	
	private final Map<UUID, User> users = new HashMap<>();
	
	public User crear(final User user) {
		final UUID id = UUID.randomUUID();
		System.out.println("id del usuario: "+id);
		return users.put(id,user);
	}
	
	public User encontrarPorId(final UUID id) {
		return users.get(id);
	}
	
	public List<User>encontrarTodos() {
		
		return users.keySet()
				.stream()
				.map(users::get)
				.toList();
	}
	
	public void eliminar(final UUID id) {
		users.remove(id);
	}
	
	 public void actualizar(final UUID id,final User newUser) {
	        if(users.containsKey(id)) {
	            users.put(id, newUser);
	        } else {
	            throw new IllegalArgumentException("El usuario con el id " + id + " no existe.");
	        }
	    }
	

}
