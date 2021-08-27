package org.hdcd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Member {
    private String userId = "spider";
    private String password = "1234";

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate dateOfBirth;

    private Address address;
    private Card card;
}
