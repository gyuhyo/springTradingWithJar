package com.pkh.springtrading.service.impl;

import com.pkh.springtrading.mapper.MemberMapper;
import com.pkh.springtrading.model.Member;
import com.pkh.springtrading.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public Member getMember(String email, String password) {
        log.info(email);
        return memberMapper.getMember(email, password);
    }
}
