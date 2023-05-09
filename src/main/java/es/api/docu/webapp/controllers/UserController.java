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
//Simport org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.api.docu.webapp.dtos.User;
import es.api.docu.webapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	//@RequestMapping(value="", method = RequestMethod.GET)
	public List<User> encontrarTodos(@RequestParam(required=false) String filtro){
		return userService.encontrarTodos();
	}
	
	@PostMapping
	//@RequestMapping(value="", method = RequestMethod.POST)
	public void crearUsuario(@RequestBody User user) {
		userService.crear(user);
	}
	
	@GetMapping("/{userId}")
	public User encontrarPorId(@PathVariable UUID userId) {
		return userService.encontrarPorId(userId);
		
	}
	@PutMapping("/{id}")
	public void actualizarUsuario(@PathVariable UUID userid, @RequestBody User user) {
     
        userService.actualizar(userid, user);
    }
	
	@DeleteMapping("/{userId}")
	//practicando el uso de ResponseEntity
	public ResponseEntity<Void> eliminarPorId(@PathVariable UUID userId) {
		userService.eliminar(userId);
		return ResponseEntity.ok(null);
	}

}
