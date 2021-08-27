package org.hdcd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.YearMonth;

@Getter
@Setter
@ToString
public class Card {
    private String no;
    private YearMonth validMonth;
}
