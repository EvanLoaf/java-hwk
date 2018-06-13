package com.gmail.evanloafakahaitao.hwk07.classTasks.task05;

public class LongestStringService {
    
    private String[] strArrayOne;
    private String[] strArrayTwo;
    private String longestString;
    private int longestStringIndex;
    private int longestStringLength;
    private int longestStringCounter;
    private String severalLongestStringResult;
    
    public String longestStringOnlyLength(String string1, String string2, String string3, String string4, String string5) {
        strArrayOne = new String[]{string1, string2, string3, string4, string5};
        longestString = strArrayOne[0];
        longestStringIndex = 0;
        for (int i = 1; i < strArrayOne.length; ++i) {
            if (strArrayOne[i].length() > longestString.length()) {
                longestString = strArrayOne[i];
                longestStringIndex = i;
            }
        }
        return "String with index " + longestStringIndex + " is the first longest string. It's length is: " + strArrayOne[longestStringIndex].length();
    }
    
    public String longestStringOutputAll(String string1, String string2, String string3, String string4, String string5) {
        strArrayTwo = new String[]{string1, string2, string3, string4, string5};
        longestStringLength = strArrayTwo[0].length();
        longestStringCounter = 1;
        for (int i = 1; i < strArrayTwo.length; ++i) {
            if (strArrayTwo[i].length() == longestStringLength) {
                ++longestStringCounter;
            }
            if (strArrayTwo[i].length() > longestStringLength) {
                longestStringLength = strArrayTwo[i].length();
                longestStringCounter = 1;
            }
            if (i == strArrayTwo.length - 1) {
                if (longestStringCounter == 1) {
                    for (int j = 0; j < strArrayTwo.length; ++j) {
                        if (strArrayTwo[j].length() == longestStringLength) {
                            longestStringIndex = j;
                        }
                    }
                    return "Here is the only longest string: " + strArrayTwo[longestStringIndex] + "\nIt's length is " + longestStringLength + " symbols.";
                } else {
                    severalLongestStringResult = "\n";
                    for (String x : strArrayTwo) {
                        if (x.length() == longestStringLength) {
                            severalLongestStringResult += x + "\n";
                        }
                    }
                    return "There are " + longestStringCounter + " strings which are the longest. Their length is " + longestStringLength + " symbols. Here they are: " + severalLongestStringResult;
                }
            }
        }
        return "Error occurred.";
    }
    
}
