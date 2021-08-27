package org.hdcd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Member {

//    private String userId = "spider";
//    prlivate String password = "1234";
    @NotBlank
    private String userId;

    @NotBlank
    @Size(max=3)
    private String userName;

    private String password;
    @Email
    private String email;

    private String gender;

    // 과거날짜인지 검사
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private Address address;
    private Card card;
}
