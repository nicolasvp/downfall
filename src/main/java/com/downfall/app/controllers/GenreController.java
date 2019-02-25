package com.downfall.app.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.downfall.app.models.entity.Artist;
import com.downfall.app.models.entity.Genre;
import com.downfall.app.models.services.IGenreService;
import com.downfall.app.models.services.IUploadService;

/*
 * Acá se manejan las rutas y se asocian a metodos
 * Se implementa crossorigin para CORS con Angular
 */

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class GenreController {

	/*
	 * Se debe inyectar el servicio para hacer uso de sus metodos
	 */
	@Autowired
	private IGenreService genreService;

	@Autowired
	private IUploadService uploadService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/genres")
	public List<Genre> index() {
		return genreService.findAll();
	}

	// Se utiliza responseEntity para validar si existe el genero segun el id, si no existe entonces retorna un mensaje de error
	// Se define el acceso solo a roles admin y user
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/genres/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Genre genre = null;
		Map<String, Object> response = new HashMap<>();

		// Validacion de spring para el acceso a datos(base de datos)
		try {
			genre = genreService.findById(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

		// Validación para género no encontrado
		if (genre == null) {
			response.put("msg", "El género con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Genre>(genre, HttpStatus.OK);
	}

	// Con la notacion @Valid se pasa el requestBody por validaciones y se guardan los resultados en la variable result
	@Secured("ROLE_ADMIN")
	@PostMapping("/genres")
	public ResponseEntity<?> create(@Valid @RequestBody Genre genre, BindingResult result) {

		Genre new_genre = null;
		Map<String, Object> response = new HashMap<>();
		
		// Si no pasa la validación entonces lista los errores y los retorna
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			new_genre = genreService.save(genre);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar guardar el nuevo género");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Género creado con éxito");
		response.put("genre", new_genre);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	// Con la notacion @Valid se pasa el requestBody por validaciones y se guardan los resultados en la variable result
	@Secured("ROLE_ADMIN")
	@PutMapping("/genres/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Genre genre, BindingResult result, @PathVariable Long id) {
		
		Genre genreDB = genreService.findById(id);
		Genre genreUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		// Si no pasa la validación entonces lista los errores y los retorna
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		// Si no se encontró el género devuelve un error
		if (genreDB == null) {
			response.put("msg", "El género no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			genreDB.setName(genre.getName());
			genreDB.setDescription(genre.getDescription());
			genreDB.setImage(genre.getImage());

			genreUpdated = genreService.save(genreDB);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar actualizar el género en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Género actualizado con éxito");
		response.put("genre", genreUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/genres/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			genreService.delete(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar eliminar el género en la base de datos, el género no existe");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Género eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	@Secured("ROLE_ADMIN")
	// Metodo para subir archivo de imagen para el artista
	@PostMapping("/genres/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Genre genre = genreService.findById(id);
		
		String fileName = null;
		
		if(!file.isEmpty()) {
			try {
				// Copia el archivo que se ha subido al directorio de uploads
				fileName = uploadService.save(file, "genres");
				
			} catch (IOException e) {
				response.put("msg", "Error al intentar subir la imagen ");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
			}
			
			// Elimina la foto anterior(si es que tiene)
			String fileNameBefore = genre.getImage();
			
			uploadService.delete(fileNameBefore, "artists");
			
			genre.setImage(fileName);
			
			genreService.save(genre);
			
			response.put("artist", genre);
			response.put("msg", "Se ha subido la imagen con éxito");
			
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	// Muestra el archivo foto del genero
	// En la URL se utiliza una regexp indicando que contendra un nombre y una extension(.+)
	@GetMapping("uploads/genres/img/{fileName:.+}")
	public ResponseEntity<Resource> showFile(@PathVariable String fileName){
	
		Resource resource = null;
		
		try {
			resource = uploadService.load(fileName, "genres");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Validación para el archivo, si no existe y no es accesible
		if(!resource.exists() && !resource.isReadable()) {
			throw new RuntimeException("Error al intentar cargar la imagen: "+ fileName);
		}
		
		// Se crea una cabecera para forzar a la descarga de la imagen
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
}
