package com.test.shorturl.repository;

import com.test.shorturl.entity.URL;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface ShortURLRepository {

    String encodingURL(int idx);

    String findURL(String encURL);

//    DB에 입력받은 URL 존재 여부 확인
    String findEncodedURL(String rawURL);

//    URL 저장
    String saveURL(String rawURL);

    void addRequestCount(String encURL);

    long printRequestCount(String encURL);
}
