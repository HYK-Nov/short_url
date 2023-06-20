package com.test.shorturl.service;

import com.test.shorturl.entity.URL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShortURLServiceTest {

    @Autowired
    ShortURLService shortURLService;

    @Test
    public void findURLRawTest(){
//        G
        String testURL = "https://www.naver.com/";
//        W
        String url = shortURLService.findURLRaw(testURL);
        System.out.println(url);
//        T
        assertNotNull(url);
    }

//    @Test
//    public void saveURLTest(){
////        G
//        String testURL = "https://www.naver.com/";
//        URL url = URL.builder()
//                .urlRaw(testURL)
//                .urlEncoded("aHR0cHM6Ly93d3cubmF2ZXIuY29tLw==")
//                .build();
////        W
//        shortURLService.saveURL(testURL);
//        System.out.println(url);
////        T
//        assertEquals(testURL, shortURLService.findURLRaw(testURL).getUrlRaw());
//    }
}
