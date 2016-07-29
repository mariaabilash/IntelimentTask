package com.inteliment.spring.service;

import com.inteliment.spring.dto.SearchCountDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchTextCountService
{
    public SearchCountDTO generateSearchCountDTO(String[] searchTexts)
    {
        List<Map<String, Integer>> searchCount = new ArrayList<Map<String, Integer>>();
        for (String searchText : searchTexts)
        {
            int count = StringUtils.countMatches(Paragraph.TEXT, searchText);
            searchCount.add(createSearchTextCountMap(searchText, count));
        }
        SearchCountDTO dto = new SearchCountDTO();
        dto.setCounts(searchCount);
        return dto;
    }

    private Map<String, Integer> createSearchTextCountMap(String searchText, int count)
    {
        Map<String, Integer> textCountMap = new HashMap<String, Integer>();
        textCountMap.put(searchText, count);
        return textCountMap;
    }
}
