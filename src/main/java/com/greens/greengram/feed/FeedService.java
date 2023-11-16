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

    public List<FeedSelVo> getFeed(int page, int loginedIuser, int targetIuser){
        final int ROW_COUNT = 30;
        FeedSelDto dto = FeedSelDto.builder()
                .iuser(loginedIuser)
                .targetIuser(targetIuser)
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
        System.out.println("--------------");
        if(iFeedList.size() > 0) {
            List<FeedPicsVo> feedPicsList = mapper.selFeedPics(iFeedList);
            for (FeedPicsVo vo : feedPicsList) {
                FeedSelVo feedVo = feedMap.get(vo.getIfeed());
                List<String> strPicsList = feedVo.getPics();
                strPicsList.add(vo.getPic());
            }
        }

        // pics에 각 칼럼주솟값에 따라 pic들을 넣기 위한 과정입니다.
        return feedSelVoList;
    }

    // 좋아요:1, 취소:2
    public ResVo procFav(FeedFavProcDto dto) { // 데이터가 공급되는 겁니다.
        // 방법 A ( 쿼리문 3개)
        // 1 있는지 없는지 확인한다.
        // 2 있으면 삭제처리, 없으면 등록처리

        // 방법 B ( 쿼리문 2개 )
        // 1 딜리트먼저
/*        int num2 = 2;
        int num = mapper.delFeedFav(dto);
        if(num == 0){
            int result = mapper.insFeedFav(dto);
            return new ResVo(result);
        }
        return new ResVo(num2);*/

        int affectedRow = mapper.delFeedFav(dto);
        if(affectedRow == 1) {
            return new ResVo(2);
        }

        int affectedRow2 = mapper.insFeedFav(dto);
        if(affectedRow2 == 1) {
            return new ResVo(1);
        }
        return null;
    }
}
