package com.example.rest.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.model.Categoria;
import com.example.rest.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {

		return categoriaRepository.findAll();

	}

	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(categoriaSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(categoriaSalva);
	}

//	@GetMapping
//	public ResponseEntity<?> listarCategoria(){
//		List<Categoria> categorias = categoriaRepository.findAll();
//		return !categorias.isEmpty()?ResponseEntity.ok(categorias):ResponseEntity.notFound().build();
//		
//	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		Categoria categoria = categoriaRepository.findById(codigo).orElse(null);
		if (categoria != null) {
			return ResponseEntity.ok(categoria);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/{codigo2}")
	public ResponseEntity<Categoria> buscarPeloCodigo2(@PathVariable Long codigo) {
		return this.categoriaRepository.findById(codigo).map(categoria -> ResponseEntity.ok(categoria))
				.orElse(ResponseEntity.notFound().build());
	}

}
