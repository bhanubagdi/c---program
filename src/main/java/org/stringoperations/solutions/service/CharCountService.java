package org.stringoperations.solutions.service;

import org.springframework.stereotype.Service;

@Service
public class CharCountService {

    public String countEachCharInWord(String stringWithoutSpace) {
        String output = "";
        stringWithoutSpace = stringWithoutSpace + "$"; //adding a delimiter
        if (stringWithoutSpace.isEmpty()) {
            return "";
        }
        if (stringWithoutSpace.length() == 1) {
            return output +  stringWithoutSpace + "1";
        }
        char temp = stringWithoutSpace.charAt(0);
        int count = 1;
        for (int i=1; i < stringWithoutSpace.length(); i++) {
            if (temp != stringWithoutSpace.charAt(i)) {
                output = output + temp + count;
                temp = stringWithoutSpace.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        return output;
    }
}
