package com.greens.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeedSelDto {
    private int loginedIuser; // 로그인한 iuser
    private int targetIuser; // 보고자하는 프로필 주인 iuser
    // 어느 특정한 사람의 피드를 보겠다,
    // 없다면 다 보겠다는 의미입니다.
    private int iuser;
    private int startIdx;
    private int rowCount;
}