package com.inteliment.spring.service;

import com.inteliment.spring.dto.SearchTextCount;
import com.inteliment.spring.dto.TopNTextCountDTO;
import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class CSVMessageConverter extends AbstractHttpMessageConverter<TopNTextCountDTO>
{
    public static final MediaType MEDIA_TYPE =
        new MediaType("text", "csv", Charset.forName("utf-8"));

    public CSVMessageConverter()
    {
        super(MEDIA_TYPE);
    }

    @Override
    protected TopNTextCountDTO readInternal(Class<? extends TopNTextCountDTO> arg0,
        HttpInputMessage arg1)
    throws IOException, HttpMessageNotReadableException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected boolean supports(Class<?> arg0)
    {
        return TopNTextCountDTO.class.equals(arg0);
    }

    @Override
    protected void writeInternal(TopNTextCountDTO topNSearchDTO,
        HttpOutputMessage httpOutputMessage)
    throws IOException, HttpMessageNotWritableException
    {
        httpOutputMessage.getHeaders().setContentType(MEDIA_TYPE);
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(httpOutputMessage.getBody()), '|');
        for (SearchTextCount searchTextCount : topNSearchDTO)
        {
            writer.writeNext(new String[]{
                searchTextCount.getSearchText(),
                String.valueOf(searchTextCount.getCount())});
        }
        writer.close();
    }

}
