package com.pkh.springtrading.controller;

import com.pkh.springtrading.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("mock/")
public class MockInvestController {

    @GetMapping("mock_invest")
    public void mock_invest(HttpSession httpSession, Model model) {

        Member member = (Member) httpSession.getAttribute("user");
        model.addAttribute("user", member);

    }
}
