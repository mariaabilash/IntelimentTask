package com.inteliment.spring.controller;

import com.inteliment.spring.dto.SearchCountDTO;
import com.inteliment.spring.service.SearchTextCountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController
{
    @RequestMapping(value="/search", headers="Accept=application/json", produces=MediaType.APPLICATION_JSON_VALUE)
    public SearchCountDTO getTextCount(@RequestParam(value="searchText") String[] searchTexts)
    {
        if (searchTexts != null)
        {
            SearchTextCountService service = new SearchTextCountService();
            return service.generateSearchCountDTO(searchTexts);
        }

        return null;
    }
}
