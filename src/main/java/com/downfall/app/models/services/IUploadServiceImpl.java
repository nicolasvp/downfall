package com.downfall.app.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/*
 * Servicio para la subida de archivos(fotos)
 */
@Service
public class IUploadServiceImpl implements IUploadService{

	// Logger para utilizar como debug
	private final Logger log = LoggerFactory.getLogger(IUploadServiceImpl.class);
	
	private final static String PATH_DIRECTORY = "uploads";
	
	@Override
	public Resource load(String fileName) throws MalformedURLException {
		// Se obtiene la ruta al directorio que se creo(no estará dentro del paquete war o jar al hacer el deploy) uploads
		// Se debe colocar la ruta completa
		Path pathFile = getPath(fileName);
		
		// Log para imprimir en consola la ruta de la imagen
		log.info(pathFile.toString());

		Resource resource = new UrlResource(pathFile.toUri());

		// Validación para el archivo, si no existe y no es accesible
		if(!resource.exists() && !resource.isReadable()) {
			throw new RuntimeException("Error al intentar cargar la imagen: "+ fileName);
		}
		
		return resource;
	}

	@Override
	public String save(MultipartFile file) throws IOException {
		
		// Se obtiene el nombre del archivo, se concatena un string aleatorio para evitar el choque de nombre y se quitan los espacios en blanco
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
		
		// Se obtiene la ruta al directorio que se creo(no estará dentro del paquete war o jar al hacer el deploy) uploads
		// Se debe colocar la ruta completa
		Path pathFile = getPath(fileName);
		
		// Log para imprimir en consola la ruta de la imagen
		log.info(pathFile.toString());
		
		// Copia el archivo que se ha subido al directorio de uploads
		Files.copy(file.getInputStream(), pathFile);
		
		return fileName;
	}

	@Override
	public Boolean delete(String fileName) {
		
		// Elimina la foto anterior(si es que tiene)
		if(fileName != null && fileName.length() > 0) {
			// Se obtiene la ruta de la foto anterior
			Path pathFileBefore = getPath(fileName);
			
			// Se convierte en archivo la foto anterior
			File fileBefore = pathFileBefore.toFile();
			
			// Valida que exista el archivo
			if(fileBefore.exists() && fileBefore.canRead()) {
				// Se elimina el archivo
				fileBefore.delete();
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Path getPath(String fileName) {
		return Paths.get(PATH_DIRECTORY).resolve(fileName).toAbsolutePath();
	}

}
