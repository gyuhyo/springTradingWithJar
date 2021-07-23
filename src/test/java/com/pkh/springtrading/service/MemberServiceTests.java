package com.pkh.springtrading.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void getMemberTest() {
        System.out.println(memberService.getMember("editplus@kakao.com", "gkdlfn22!!"));
    }
}
