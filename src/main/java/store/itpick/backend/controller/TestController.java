package store.itpick.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.itpick.backend.model.rank.CommunityType;
import store.itpick.backend.model.rank.PeriodType;
import store.itpick.backend.util.Redis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Redis redis;

    @GetMapping("/*.ico")
    void pathMatch() {
        System.out.println("favicon.ico.");
    }

    @GetMapping("/rank/day")
    public void dayTest() {
        redis.saveDay();
    }

    @GetMapping("/rank/week")
    public void weekTest() {
        redis.saveWeek();
    }

    @GetMapping("/rank/total")
    public void totalTest() {
        redis.saveTotalRanking(PeriodType.BY_REAL_TIME);
        redis.saveTotalRanking(PeriodType.BY_DAY);
        redis.saveTotalRanking(PeriodType.BY_WEEK);
    }

    @GetMapping("/save-manually")
    public String saveManually() {
        CommunityType communityType = RankController.getCommunityType("zum");
        String date = "240811";
        if (communityType == null || !RankController.isValidatedDate(PeriodType.BY_DAY, date)) {
            return "failed";
        }
        List<String> keywordList = getKeywordList(communityType, date);
        redis.saveDay(communityType, date, keywordList);

        return "success";
    }

    private List<String> getKeywordList(CommunityType communityType, String date) {
        switch (communityType) {
            case NAVER:
                break;
            case NATE:
                break;
            case ZUM:
                switch (date) {
                    case "240805":
                        break;
                    case "240806":
                        break;
                    case "240807":
                        break;
                    case "240808":
                        break;
                    case "240809":
                        break;
                    case "240810":
                        break;
                    case "240811":
                        return new ArrayList<>(Arrays.asList(
                                "탁구 동메달", "정주리 오형제", "임영웅", "해리스 트럼프", "전동스쿠터 경찰",
                                "톨라 마라톤", "쓰레기 풍선 240여개", "엔하이픈 재팬", "한동훈 김경수 복권", "젤렌스키 침략자"));
                }
                break;
            case GOOGLE:
                break;
            case NAMUWIKI:
                break;
        }
        return null;
    }
}
