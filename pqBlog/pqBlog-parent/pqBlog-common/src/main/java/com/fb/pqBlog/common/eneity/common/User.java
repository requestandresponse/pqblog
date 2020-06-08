package com.fb.pqBlog.common.eneity.common;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;

    @Pattern(regexp = "/^[1]([3-9])[0-9]{9}$/")
    private String phone;

    @Past
    private Date birthday;

    private String status;

}
