package com.greens.greengram.feed.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedInsDto {
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;
}
// 여기다 ifeed를 추가해서 쓸 수도 있지만 굳이 그러지 않고 따로 분리하는 이유는
// swagger의 문서상 이유 떄문입니다.