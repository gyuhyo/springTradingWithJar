package com.pkh.springtrading.controller;

import com.pkh.springtrading.model.Member;
import com.pkh.springtrading.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("member/")
@Log4j2
public class LoginController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "doLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> doLogin(@RequestBody Member member, HttpSession httpSession) {

       log.info(member);

       Member loginUser = memberService.getMember(member.getEmail(), member.getPassword());
       ResponseEntity<Object> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);
       if (loginUser != null) {
           httpSession.setAttribute("user", loginUser);
           responseEntity = new ResponseEntity<>(loginUser, HttpStatus.OK);
       }

        return responseEntity;
    }
}
