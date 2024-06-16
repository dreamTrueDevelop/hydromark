package com.hydromark.in.DTO;

import lombok.Data;

@Data
public class Enquiry {
    private String orgName;
    private String orgEmail;
    private String orgMobile;
    private int productId;
    private String enquiry;
}
