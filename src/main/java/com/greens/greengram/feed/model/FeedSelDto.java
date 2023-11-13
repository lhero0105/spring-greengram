package com.greens.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeedSelDto {
    private int startIdx;
    private int rowCount;
}