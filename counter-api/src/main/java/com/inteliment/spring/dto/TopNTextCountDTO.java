package com.inteliment.spring.dto;

import java.util.ArrayList;
import java.util.Collection;

public class TopNTextCountDTO extends ArrayList<SearchTextCount>
{
    private static final long serialVersionUID = 7267476040178613410L;

    public TopNTextCountDTO()
    {
    }

    public TopNTextCountDTO(Collection<SearchTextCount> topNCounts)
    {
        super(topNCounts);
    }
}
