package es.api.docu.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import es.api.docu.webapp.dtos.Blog;

@Service
public class BlogService {
	
	private final Map<UUID, Blog> blogs = new HashMap<>();
	
	public Blog crear(final Blog blog) {
		final UUID id = UUID.randomUUID();
		System.out.println("id del blog: "+id);
		return blogs.put(id,blog);
	}
	
	public Blog encontrarPorId(final UUID id) {
		return blogs.get(id);
	}
	
	public List<Blog>encontrarTodos() {
		
		return blogs.keySet()
				.stream()
				.map(blogs::get)
				.toList();
	}
	
	public void eliminar(final UUID id) {
		blogs.remove(id);
	}
	
	 public void actualizar(final UUID id,final Blog newBlog) {
	        if(blogs.containsKey(id)) {
	            blogs.put(id, newBlog);
	        } else {
	            throw new IllegalArgumentException("El blog con el id " + id + " no existe.");
	        }
	    }
	

}
