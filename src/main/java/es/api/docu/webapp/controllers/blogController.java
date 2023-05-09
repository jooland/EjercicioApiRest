package es.api.docu.webapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.api.docu.webapp.dtos.Blog;
import es.api.docu.webapp.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class blogController {
	@Autowired
	private BlogService blogService;
	
	@GetMapping
	
	public List<Blog> encontrarTodos(@RequestParam(required=false) String filtro){
		return blogService.encontrarTodos();
	}
	
	@PostMapping
	
	public void crearblog(@RequestBody Blog blog) {
		blogService.crear(blog);
	}
	
	@GetMapping("/{blogId}")
	public Blog encontrarPorId(@PathVariable UUID blogId) {
		return blogService.encontrarPorId(blogId);
		
	}
	@PutMapping("/{id}")
	public void actualizarBlog(@PathVariable UUID blogid, @RequestBody Blog blog) {
     
        blogService.actualizar(blogid, blog);
    }
	
	@DeleteMapping("/{blogId}")
	//practicando el uso de ResponseEntity
	public ResponseEntity<Void> eliminarPorId(@PathVariable UUID blogId) {
		blogService.eliminar(blogId);
		return ResponseEntity.ok(null);
	}

}
