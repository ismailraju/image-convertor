package com.raju.imageconvertor.controller;


import com.raju.imageconvertor.payload.Criteria;
import com.raju.imageconvertor.service.ImageService;
import com.raju.imageconvertor.payload.RequestData;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ImageController {
    @Autowired
    public ImageService imageService;


    @GetMapping("/abc")
    public void homeexpage() {
        int i = 0 / 1;
        int j = 1 / 0;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        if (!model.containsAttribute("requestData")) {

            model.addAttribute("requestData", new RequestData());
        }
        return "index";
    }

    @GetMapping("/upload")
    public String uploadpage(Model model) {
        return homepage(model);
    }

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> resizeImage(@Valid @ModelAttribute RequestData data,
                                         BindingResult bindingResult,
                                         RedirectAttributes attributes,
                                         Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            model.addAttribute("requestData", data);

            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(
                    errors,
                    HttpStatus.BAD_REQUEST);
        }


        String fileName = StringUtils.cleanPath(data.file.getOriginalFilename());
        String extension = FilenameUtils.getExtension(fileName);
        String fileNameout = fileName.replace("." + extension, Math.random() + "." + extension);


        InputStream inputStream = data.file.getInputStream();
        BufferedImage imBuff = ImageIO.read(inputStream);


        BufferedImage bufferedImage = imageService.resizeImage(new Criteria(imBuff, data.width, data.height));


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, extension, baos);
        byte[] bytes = baos.toByteArray();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileNameout + "\"")
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(bytes);


    }


}
