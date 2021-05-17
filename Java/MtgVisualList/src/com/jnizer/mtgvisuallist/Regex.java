package com.jnizer.mtgvisuallist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    final protected String regex = "(([0-9]+)(\\s)(\\D+)(\\(\\w+\\))(\\s)(\\d+))";
    
    public boolean applyRegex(String list){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(list);
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        return true;
    }
    
}
