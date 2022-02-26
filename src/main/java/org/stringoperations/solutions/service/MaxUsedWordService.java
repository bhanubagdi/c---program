package org.stringoperations.solutions.service;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MaxUsedWordService {

    public Map<String, Integer> maxUsedWordsAndCount() {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/resources/test.txt"))){
            StringBuilder sb = new StringBuilder();
            int intch;
            while((intch = bis.read()) != -1){
                char ch = (char)intch;
                sb.append(ch);
                if(' ' == ch || '.' ==  ch){
                    String word = sb.toString().toLowerCase().trim();
                    word = word.replace(".","").trim();
                    // System.out.println(word);
                    if(map.containsKey(word)){
                        map.put(word, map.get(word)+1);
                        max = max<map.get(word) ? map.get(word) : max;
                    }
                    else {
                        map.put(word, 1);
                        max = max<1? 1 : max;
                    }
                    sb.delete(0,sb.length());
                }
            }

        }catch (IOException ex){
            System.out.println("exception occurred " + ex.getMessage());
        }
        System.out.println(max);
        final int maximum = max;
        map.keySet().stream().filter(k -> map.get(k).equals(maximum)).forEach( System.out::println);
        return map;

    }
}
