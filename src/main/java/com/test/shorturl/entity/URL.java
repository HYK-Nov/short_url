package com.test.shorturl.entity;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class URL {
    private long urlIndex;
    private String urlRaw;
    private String urlEncoded;
}
