package com.greens.greengram.feed;

import com.greens.greengram.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);

    //t_feed_pic
    int insFeedPic(FeedPicsInsProcDto dto);
    List<FeedSelVo> selFeed(FeedSelDto dto);
    List<FeedPicsVo> selFeedPics(List<Integer> p);
}