package com.raju.imageconvertor;

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
    BufferedImage src;
    int w;
    int h;

}
