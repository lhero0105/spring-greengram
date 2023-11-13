package com.greens.greengram.feed;

import com.greens.greengram.ResVo;
import com.greens.greengram.feed.model.FeedInsDto;
import com.greens.greengram.feed.model.FeedSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResVo insFeed(@RequestBody FeedInsDto dto){
        System.out.println(dto);
        service.insFeed(dto);
        return null;
    }
    @GetMapping
    public List<FeedSelVo> getFeed(int page){
        System.out.println(page);
        return service.getFeed(page);
    }
}
