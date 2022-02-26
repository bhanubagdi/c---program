package org.stringoperations.solutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.stringoperations.solutions.service.CharCountService;
import org.stringoperations.solutions.service.MaxUsedWordService;

import java.awt.*;
import java.util.Map;

@Controller
@RequestMapping("/v1")
public class StringOperationController {

    @Autowired
    private CharCountService charCountService;

    @Autowired
    private MaxUsedWordService maxUsedWordService;

    @RequestMapping(path = "/getCharCount")
    public ResponseEntity<String> getCharCount(@RequestParam("stringWithoutSpace") String stringWithoutSpace) {
        if (stringWithoutSpace.isEmpty()) {
            return new ResponseEntity<>("Input stringWithoutSpace cannot be empty", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(charCountService.countEachCharInWord(stringWithoutSpace), HttpStatus.OK);
    }

    @RequestMapping(path = "/getMaxWordAndCount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Integer>> getMaxWordAndCount() {
        return new ResponseEntity<>(maxUsedWordService.maxUsedWordsAndCount(), HttpStatus.OK);
    }
}
