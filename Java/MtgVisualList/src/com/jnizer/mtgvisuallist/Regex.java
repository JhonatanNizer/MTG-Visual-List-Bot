package com.jnizer.mtgvisuallist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    final protected String regex = "(([0-9]+)(\\s)(\\D+)(\\(\\w+\\))(\\s)(\\d+))";
    final protected Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

    public boolean applyRegex(String list) {
        final Matcher matcher = pattern.matcher(list);
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
            System.out.println("");
        }
        return true;
    }

}
