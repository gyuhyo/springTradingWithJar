package com.pkh.springtrading.service;

import com.pkh.springtrading.model.Member;

public interface MemberService {
    public Member getMember(String email, String password);
}
