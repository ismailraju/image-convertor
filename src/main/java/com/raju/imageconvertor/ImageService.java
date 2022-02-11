package com.raju.imageconvertor;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ImageService extends Criteria {


    BufferedImage simpleResizeImage(BufferedImage originalImage, int targetWidth) throws Exception {
        return Scalr.resize(originalImage, targetWidth);
    }


    BufferedImage resizeImage(Criteria c) throws Exception {

        System.out.println("input h:" + c.src.getHeight() + " w:" + c.src.getWidth());
        Scalr.Mode mode = Scalr.Mode.AUTOMATIC;
        BufferedImage resized;
        if (c.h == 0)
            mode = Scalr.Mode.FIT_TO_WIDTH;
        else if (c.w == 0)
            mode = Scalr.Mode.FIT_TO_HEIGHT;
        if (c.src.getHeight() < c.h && c.src.getWidth() < c.w) {
            resized = c.src;
        } else {
            resized = Scalr.resize(c.src,
                    Scalr.Method.ULTRA_QUALITY,
                    Scalr.Mode.FIT_EXACT,
                    c.w,
                    c.h);

            System.out.println("output h:" + resized.getHeight() + " w:" + resized.getWidth());
        }
        return resized;
    }

}
