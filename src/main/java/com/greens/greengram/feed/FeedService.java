package com.greens.greengram.feed;

import com.greens.greengram.ResVo;
import com.greens.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo insFeed(FeedInsDto dto){
        FeedInsProcDto pDto = new FeedInsProcDto(dto);// 생성자를 통한 값 전달
        System.out.println(dto);
        System.out.println(pDto);
        int result = mapper.insFeed(pDto);
        // 0,1을 체크하는 곳입니다 (트랜젝션)
        System.out.println(result);
        System.out.println(pDto);

        FeedPicsInsProcDto p2Dto = new FeedPicsInsProcDto(pDto.getIfeed(), dto.getPics());
        int result2 = mapper.insFeedPic(p2Dto);
        System.out.println("result = " + result2);
        return new ResVo(pDto.getIfeed());
    }

    public List<FeedSelVo> getFeed(int page){
        final int ROW_COUNT = 30;//
        FeedSelDto dto = FeedSelDto.builder()
                .startIdx((page - 1) * ROW_COUNT)
                .rowCount(ROW_COUNT)
                .build();
        List<FeedSelVo> feedSelVoList = mapper.selFeed(dto);

        List<Integer> iFeedList = new ArrayList<>();
        Map<Integer, FeedSelVo> feedMap = new HashMap();
        for ( FeedSelVo vo : feedSelVoList ) {
            System.out.println(vo);
            iFeedList.add(vo.getIfeed());
            feedMap.put(vo.getIfeed(), vo);
        }

        for (FeedSelVo vo : feedSelVoList ) {
            System.out.println(vo);
            iFeedList.add(vo.getIfeed());
        }
        System.out.println("--------------");
        List<FeedPicsVo> feedPicsList = mapper.selFeedPics(iFeedList);
        for (FeedPicsVo vo: feedPicsList) {
            FeedSelVo feedVo = feedMap.get(vo.getIfeed());
            List<String> strPicsList = feedVo.getPics();
            strPicsList.add(vo.getPic());
        }



        return feedSelVoList;
    }
}
