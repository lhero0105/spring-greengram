package com.greens.greengram.feed.model;

import lombok.*;

@Getter
@Setter
@ToString
public class FeedInsProcDto {
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;

    public FeedInsProcDto(FeedInsDto dto) {
        iuser = dto.getIuser();
        contents = dto.getContents();
        location = dto.getLocation();
    }
}