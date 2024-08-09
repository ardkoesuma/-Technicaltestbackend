package com.xk.Ujian.dto;

import jakarta.validation.constraints.NotBlank; 
 

public class EmployeeRequest {

     
    private Long id;

    @NotBlank(message = "Name Tidak Boleh Kosong")
    private String name;

    @NotBlank(message = "Position Tidak Boleh Kosong")
    private String position;

    @NotBlank(message = "Gambar Tidak Boleh Kosong") 
    private String imageBase64;
 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
