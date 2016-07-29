package com.inteliment.spring.service;

import com.inteliment.spring.dto.SearchTextCount;
import com.inteliment.spring.dto.TopNTextCountDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TopNTextCountService
{
    public TopNTextCountDTO generateTopNTextCountDTO(int topN)
    {
        Map<String, Integer> textCountMap = new TreeMap<String, Integer>();
        String text = Paragraph.TEXT.toLowerCase();

        for (String searchText : StringUtils.split(text))
        {
            String word = StringUtils.removePunctuations(searchText);
            int count = StringUtils.countMatches(text, word);
            if (!textCountMap.containsKey(word))
            {
                textCountMap.put(word, count);
            }
        }

        Set<Entry<String, Integer>> set = textCountMap.entrySet();
        List<Entry<String, Integer>> sortedList = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort(sortedList, new SortByValueComparator());

        List<Entry<String, Integer>> topNSortedList = (sortedList.size() > topN) ?
            sortedList.subList(0, topN) : sortedList;
        TopNTextCountDTO topNSearchDTO = new TopNTextCountDTO();
        for (Map.Entry<String, Integer> entry : topNSortedList)
        {
            SearchTextCount textCount = new SearchTextCount();
            textCount.setSearchText(entry.getKey());
            textCount.setCount(entry.getValue());
            topNSearchDTO.add(textCount);
        }
        return topNSearchDTO;
    }

    class SortByValueComparator implements Comparator <Map.Entry<String, Integer>>
    {
        public int compare(Map.Entry<String,Integer> value1, Map.Entry<String,Integer> value2)
        {
            if (value1.getValue() < value2.getValue())
            {
                return 1;
            }
            else if (value1.getValue() < value2.getValue())
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }
}
