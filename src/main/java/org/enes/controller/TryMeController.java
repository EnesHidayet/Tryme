package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.service.CloudinaryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/Try-Me")
public class TryMeController {

    private final CloudinaryService cloudinaryService;

    @PostMapping(value = "/try-me-app", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> tryProduct(@RequestParam("UserPhoto") MultipartFile file,@RequestParam("ProductPhoto") MultipartFile file1) {
        try {
            String imageUrl = cloudinaryService.uploadFile(file);
            String imageUrl1 = cloudinaryService.uploadFile(file1);
            return ResponseEntity.ok("Virtual try on successfully. URL: " + imageUrl+" "+imageUrl1);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading image.");
        }
    }

}
