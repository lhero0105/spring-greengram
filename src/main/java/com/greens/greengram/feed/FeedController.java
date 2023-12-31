package com.greens.greengram.feed;

import com.greens.greengram.ResVo;
import com.greens.greengram.feed.model.FeedFavProcDto;
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
    public List<FeedSelVo> getFeed(int page, int iuser){
        System.out.println(page);
        return service.getFeed(page, iuser, 0);
        // 0이 false의미 입니다.
    }
    @GetMapping("/{target}")
    public List<FeedSelVo> getMyFeed(@PathVariable int target, int page, int loginedIuser){ // 이부분 작명은 프론트랑 같아야만 합니다.
        System.out.println(page);
        return service.getFeed(page, loginedIuser, target);
        // 0이 false의미 입니다.
    }
    @GetMapping("/{ifeed}/fav") // 그 피드에 좋아요처리를 합니다.
    public ResVo porcFac(@PathVariable int ifeed, int iuser){
        System.out.println("ifeed: " + ifeed);
        System.out.println("iuser: " + iuser);
        FeedFavProcDto dto = FeedFavProcDto.builder()
                .ifeed(ifeed)
                .iuser(iuser)
                .build();
        return service.procFav(dto);
    }
}
