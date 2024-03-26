package com.lecture.springbasic;

import com.lecture.springbasic.member.Grade;
import com.lecture.springbasic.member.Member;
import com.lecture.springbasic.member.MemberService;
import com.lecture.springbasic.member.memberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
