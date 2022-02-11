package com.raju.imageconvertor.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Criteria {
    public BufferedImage src;
    public int w;
    public int h;

}
