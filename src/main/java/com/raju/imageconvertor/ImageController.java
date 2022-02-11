package com.raju.imageconvertor;


import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

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
        model.addAttribute("requestData", new RequestData());
        return "index";
    }

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> resizeImage(@ModelAttribute RequestData data, RedirectAttributes attributes) throws Exception {


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
