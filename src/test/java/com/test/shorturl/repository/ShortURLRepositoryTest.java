package com.test.shorturl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShortURLRepositoryTest {

    @Autowired
    ShortURLRepository shortURLRepository;

    @Test
    public void findURLTest(){
        String test = "aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8=";
        String result = shortURLRepository.findURL(test);
        assertNull(result);
    }

    @Test
    public void findEncodedURLTest(){
//        G
        String testURL = "https://www.naver.com/";
//        W
        String result = shortURLRepository.findEncodedURL(testURL);
//        T
        assertNull(result);
    }

    @Test
    public void saveURLTest(){
        String testURL = "https://www.google.com/";
        String result = shortURLRepository.saveURL(testURL);
        System.out.println(result);
//        assertEquals(testURL, url);
    }

    @Test
    public void addRequestCountTest(){
        String testURL = "https://www.google.com/";
        String encURL = shortURLRepository.saveURL(testURL);
    }
}
