package org.hdcd.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@ApiModel("보드테스트")
public class Board {
    @ApiModelProperty(value = "보드번호")
    private long boardNo;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
}
