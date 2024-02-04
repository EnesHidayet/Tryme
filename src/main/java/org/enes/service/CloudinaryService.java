package org.enes.service;

import com.cloudinary.Cloudinary;

import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.Map;

@Service
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService(

            @Value("${spring.cloudinary.cloud-name}") String cloudName,

            @Value("${spring.cloudinary.api-key}") String apiKey,

            @Value("${spring.cloudinary.api-secret}") String apiSecret) {

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(

                "cloud_name", cloudName,

                "api_key", apiKey,

                "api_secret", apiSecret));

    }

    public String uploadFile(MultipartFile file) throws IOException {

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        return (String) uploadResult.get("secure_url");

    }

    public String deleteFile(String publicId) throws IOException {

        Map deleteResult = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());

        return (String) deleteResult.get("result");

    }

}
