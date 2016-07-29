package com.inteliment.spring.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
    public static int countMatches(String text, String toMatch)
    {
        int count = 0;
        String patternString = "\\b" + toMatch.toLowerCase() + "\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text.toLowerCase());
        while (matcher.find())
        {
            count++;
        }
        return count;
    }

    public static String removePunctuations(String word)
    {
        return word.replaceAll("\\s*\\p{Punct}+\\s*$", "");
    }

    public static String[] split(String toSplit)
    {
        return toSplit.split("\\s+");
    }
}
