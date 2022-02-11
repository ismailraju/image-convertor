package com.raju.imageconvertor;


import com.raju.imageconvertor.validator.ValidImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {

    @NotNull
    @Range(min = 6, max = 1000)
    public Integer width;

    @NotNull
    @Range(min = 6, max = 1000)
    public Integer height;

    @NotNull
    @ValidImage
    public MultipartFile file;
}
