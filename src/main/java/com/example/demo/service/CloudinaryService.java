package com.example.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import jakarta.annotation.Resource;

@Service
public class CloudinaryService {
	@Resource
	private Cloudinary cloudinary;
	
	public String uploadImg(MultipartFile file, String folderName, String fileName) {
		System.out.println("cloudinary: " + cloudinary);
		System.out.println("uploadImg");
		
        try{
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", folderName);
            options.put("public_id", fileName);
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            System.out.println("url: " + uploadedFile.get("secure_url").toString());
            return uploadedFile.get("secure_url").toString();

        }catch (Exception e){
        	System.out.println(e);
            return null;
        }
    }
}
