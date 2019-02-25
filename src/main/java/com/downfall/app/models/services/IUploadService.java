package com.downfall.app.models.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/*
 * Servicio para la subida de archivos(fotos)
 * Se utiliza un segundo parametro (directory) para indicar a que carpeta corresponde la subida de archivo, ya que se reutiliza este service para genres, artists y albums
 */
public interface IUploadService {
	
	public Resource load(String fileName, String directory) throws MalformedURLException;
	
	public String save(MultipartFile file, String directory) throws IOException;
	
	public Boolean delete(String fileName, String directory);
	
	public Path getPath(String fileName, String directory);

}
