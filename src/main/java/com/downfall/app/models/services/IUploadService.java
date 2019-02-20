package com.downfall.app.models.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/*
 * Servicio para la subida de archivos(fotos)
 */
public interface IUploadService {
	
	public Resource load(String fileName) throws MalformedURLException;
	
	public String save(MultipartFile file) throws IOException;
	
	public Boolean delete(String fileName);
	
	public Path getPath(String fileName);

}
