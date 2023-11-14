package com.greens.greengram.feed.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class FeedPicsVo {
    //FeedPicsVo가 List가 되어야합니다.
    private int ifeed;
    private String pic;
}
