package com.downfall.app.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.downfall.app.models.entity.Album;
import com.downfall.app.models.services.IAlbumService;

/*
 * Acá se manejan las rutas y se asocian a metodos
 * Se implementa crossorigin para CORS con Angular
 */

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AlbumController {

	/*
	 * Se debe inyectar el servicio para hacer uso de sus metodos
	 */
	@Autowired
	private IAlbumService albumService;
	
	// Logger para utilizar como debug
	private final Logger log = LoggerFactory.getLogger(AlbumController.class);
	
	@GetMapping("/albums")
	public List<Album> index(){
		return albumService.findAll();
	}
	
	@GetMapping("/albums/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Album album = null;
		Map<String, Object> response = new HashMap<>();

		// Validacion de spring para el acceso a datos(base de datos)
		try {
			album = albumService.findById(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

		// Validación para album no encontrado
		if (album == null) {
			response.put("msg", "El Album con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Album>(album, HttpStatus.OK);
	}
	
	@PostMapping("/albums")
	public ResponseEntity<?> create(@Valid @RequestBody Album album, BindingResult result) {
		
		Album new_album = null;
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
			new_album = albumService.save(album);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar guardar el nuevo album");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Album creado con éxito");
		response.put("album", new_album);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/albums/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Album album, BindingResult result, @PathVariable Long id) {
		
		Album albumDB = albumService.findById(id);
		Album albumUpdated = null;
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
		if (albumDB == null) {
			response.put("msg", "El album no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			albumDB.setName(album.getName());
			albumDB.setImage(album.getImage());
			albumDB.setReleaseDate(album.getReleaseDate());
			albumDB.setArtist(album.getArtist());

			albumUpdated = albumService.save(albumDB);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar actualizar el album en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Album actualizado con éxito");
		response.put("album", albumUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/albums/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();

		// Elimina la foto asociada al album y luego elimina el album
		try {
			Album album = albumService.findById(id);
			
			// Elimina la foto anterior(si es que tiene)
			String fileNameBefore = album.getImage();
			
			if(fileNameBefore != null && fileNameBefore.length() > 0) {
				// Se obtiene la ruta de la foto anterior
				Path pathFileBefore = Paths.get("uploads").resolve(fileNameBefore).toAbsolutePath();
				
				// Se convierte en archivo la foto anterior
				File fileBefore = pathFileBefore.toFile();
				
				// Valida que exista el archivo
				if(fileBefore.exists() && fileBefore.canRead()) {
					// Se elimina el archivo
					fileBefore.delete();
				}
			}
			
			albumService.delete(id);
		} catch (DataAccessException e) {
			response.put("msg", "Error al intentar eliminar el album en la base de datos, el album no existe");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Album eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	// Metodo para subir archivo de imagen para el album
	@PostMapping("/albums/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Album album = albumService.findById(id);
		
		if(!file.isEmpty()) {
			// Se obtiene el nombre del archivo, se concatena un string aleatorio para evitar el choque de nombre y se quitan los espacios en blanco
			String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
			
			// Se obtiene la ruta al directorio que se creo(no estará dentro del paquete war o jar al hacer el deploy) uploads
			// Se debe colocar la ruta completa
			Path pathFile = Paths.get("uploads").resolve(fileName).toAbsolutePath();
			
			// Log para imprimir en consola la ruta de la imagen
			log.info(pathFile.toString());
			
			try {
				// Copia el archivo que se ha subido al directorio de uploads
				Files.copy(file.getInputStream(), pathFile);
			} catch (IOException e) {
				response.put("msg", "Error al intentar subir la imagen " + fileName);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
			}
			
			// Elimina la foto anterior(si es que tiene)
			String fileNameBefore = album.getImage();
			
			if(fileNameBefore != null && fileNameBefore.length() > 0) {
				// Se obtiene la ruta de la foto anterior
				Path pathFileBefore = Paths.get("uploads").resolve(fileNameBefore).toAbsolutePath();
				
				// Se convierte en archivo la foto anterior
				File fileBefore = pathFileBefore.toFile();
				
				// Valida que exista el archivo
				if(fileBefore.exists() && fileBefore.canRead()) {
					// Se elimina el archivo
					fileBefore.delete();
				}
			}
			
			album.setImage(fileName);
			
			albumService.save(album);
			
			response.put("album", album);
			response.put("msg", "Se ha subido la imagen con éxito");
			
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	// Muestra el archivo foto del album
	// En la URL se utiliza una regexp indicando que contendra un nombre y una extension(.+)
	@GetMapping("uploads/img/{fileName:.+}")
	public ResponseEntity<Resource> showFile(@PathVariable String fileName){
		// Se obtiene la ruta al directorio que se creo(no estará dentro del paquete war o jar al hacer el deploy) uploads
		// Se debe colocar la ruta completa
		Path pathFile = Paths.get("uploads").resolve(fileName).toAbsolutePath();
		
		// Log para imprimir en consola la ruta de la imagen
		log.info(pathFile.toString());
		
		Resource resource = null;
		
		try {
			resource = new UrlResource(pathFile.toUri());
		} catch (MalformedURLException e) {
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
