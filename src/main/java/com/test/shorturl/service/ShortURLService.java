package com.test.shorturl.service;

import com.test.shorturl.entity.URL;

public interface ShortURLService {
    String findURLRaw(String urlRaw);

    void saveURL(String urlRaw);
}
