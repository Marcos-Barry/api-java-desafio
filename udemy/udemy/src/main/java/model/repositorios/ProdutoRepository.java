package model.repositorios;

import org.springframework.data.repository.CrudRepository;
import model.entidades.Produto;

public interface ProdutoRepository 
extends CrudRepository<Produto, Integer>{

}
