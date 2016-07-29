package com.inteliment.spring.controller;

import com.inteliment.spring.dto.TopNTextCountDTO;
import com.inteliment.spring.service.TopNTextCountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TopCountSearchController
{
    @RequestMapping(value="/top/{topN}", method = RequestMethod.GET, produces="text/csv")
    @ResponseBody
    public TopNTextCountDTO getTopNTextCount(@PathVariable int topN)
    {
        TopNTextCountService service = new TopNTextCountService();
        return service.generateTopNTextCountDTO(topN);
    }
}
