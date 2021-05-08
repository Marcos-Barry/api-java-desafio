package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import model.entidades.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping(path = "/clientes/qualquer")
	public Cliente obterCliente() {
		return new Cliente(30, "Marcos","378.955.867-90");
	}
	
	@GetMapping("/{id}")
	public Cliente obterClienteporId1(@PathVariable int id) {
		return new Cliente(id,"Maria","387.887.999.09");
	}
	
	@GetMapping
	public Cliente obterClienteporId2(
			@RequestParam(name="id",defaultValue="1") int id) {
		return new Cliente(id,"Theodoro","200.333.444.09");
	}
	
	
}
