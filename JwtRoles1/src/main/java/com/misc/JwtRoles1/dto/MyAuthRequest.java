package com.misc.JwtRoles1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyAuthRequest {

    private String myusername;
    private String mypassword;

}
