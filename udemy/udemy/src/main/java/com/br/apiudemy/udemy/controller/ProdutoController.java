package com.br.apiudemy.udemy.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiudemy.udemy.model.entidades.Produto;
import com.br.apiudemy.udemy.model.repositorios.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path="/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(
			@PathVariable String parteNome) {
		//return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
		return produtoRepository.searchByNameLike(parteNome);
	}

	@GetMapping(path="/{id}")
	public Optional<Produto> obterProduto(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	/*@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	} */
	
	@DeleteMapping(path="/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	
	@GetMapping(path="/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Produto> obterProdutosPorId(
			@PathVariable int numeroPagina,
			@PathVariable int qtdePagina){
		if(qtdePagina >=5) qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return produtoRepository.findAll(page);
		
	}
}
