package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(countWord(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(wordInstances(urlToString("http://erdani.com/tdpl/hamlet.txt"), "HAMLET"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countWord(final String strToCheck) {
        String[] wordArr = strToCheck.split(" ");
        int wordCount = wordArr.length;
        return wordCount;
    }

    public static int wordInstances(final String strToCheck, final String wordToFind) {
        int wordCount = 0;
        String[] wordArr = strToCheck.split(" ");
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i].toLowerCase().equals(wordToFind.toLowerCase())) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
