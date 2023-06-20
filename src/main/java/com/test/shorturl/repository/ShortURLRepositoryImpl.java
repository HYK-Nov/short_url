package com.test.shorturl.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ShortURLRepositoryImpl implements ShortURLRepository{

    private static final ArrayList<String> urlList = new ArrayList<>();
    private static final ArrayList<String> encodedList = new ArrayList<>();
    private static final ArrayList<Integer> requestList = new ArrayList<>();

    @Override
    public String encodingURL(int idx) {
        char[] words = "23456789abcdefghijkmnpqrstuwxyzABCDEFGHJKLMNPQRSTUWXYZ".toCharArray();
        StringBuffer sb = new StringBuffer();

//        base54: I,O,l,o,1,0 제외
//        폰트에 따라 서로 비슷하게 보이기 때문
        for (int i = 0; i < 8; i++) {
            sb.append(words[(int) (Math.random() * 55)]);
        }

        return sb.toString();
    }

    @Override
    public String findURL(String encURL) {
        if (encodedList.contains(encURL)){
            return urlList.get(encodedList.indexOf(encURL));
        }
        return null;
    }

    @Override
    public String findEncodedURL(String rawURL) {
        if (urlList.contains(rawURL)){
            return encodedList.get(urlList.indexOf(rawURL));
        }
        return null;
    }

    @Override
    public String saveURL(String rawURL) {
        if (!urlList.contains(rawURL)){
            String encURL = encodingURL(urlList.size());
            urlList.add(rawURL);
            encodedList.add(encURL);
            requestList.add(0);
            return encURL;
        }
        return findEncodedURL(rawURL);
    }

    @Override
    public void addRequestCount(String rawURL) {
        int idx = urlList.indexOf(rawURL);
        requestList.set(idx, requestList.get(idx)+1);
    }

    @Override
    public long printRequestCount(String rawURL) {
        return requestList.get(urlList.indexOf(rawURL));
    }
}
