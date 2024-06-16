package com.hydromark.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class Products {
    private Long id;
    private String productName;
    private String productDesc;
    private String productImage;
}
