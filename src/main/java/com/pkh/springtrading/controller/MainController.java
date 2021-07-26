package com.pkh.springtrading.controller;

import com.pkh.springtrading.model.Member;
import com.pkh.springtrading.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
@Log4j2
public class MainController {

    @Autowired
    private MemberService memberService;

    @Value("${local.ip}")
    private String localIp;

    @GetMapping("")
    public String home(HttpSession httpSession, Model model) {
        log.info("load home..........");

        Member member = (Member) httpSession.getAttribute("user");
        model.addAttribute("user", member);
        model.addAttribute("local_ip", localIp);

        return "home";
    }
}
