package br.com.fiap.study_apir.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/${api.version}/produtos")
public class ProdutoController {

private RepositoryProdutoMockup mockup = new RepositoryProdutoMockup();

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
      mockup.create(null);
      return ResponseEntity.status(HttpStatus.CREATED).body(mockup.create(produto));
    }
    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
      return ResponseEntity.status(HttpStatus.OK).body(mockup.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
      // Optional<Produto> optProduto = mockup.findById(id);
      // if (optProduto.isPresent()) {
      //   return ResponseEntity.ok(optProduto.get());
      // }else{
      //   return ResponseEntity.notFound().build();
      // }

      // Optional<Produto> optProduto = mockup.findById(id);
      // return optProduto.map(p -> ResponseEntity.ok(p))
      // .orElse(ResponseEntity.notFound().build());

      return mockup
      .findById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public  ResponseEntity<String> update(@PathVariable Long id, @RequestBody Produto produto){
      if (mockup.update(id, produto)) {
        return ResponseEntity.ok("Produto atualizado");
      } else {
        return ResponseEntity.notFound().build();
      }
      
    }
    @DeleteMapping
    public ResponseEntity<String> delete(){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluido");
    }
}