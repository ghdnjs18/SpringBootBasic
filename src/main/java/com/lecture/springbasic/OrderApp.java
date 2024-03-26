package com.lecture.springbasic;

import com.lecture.springbasic.member.Grade;
import com.lecture.springbasic.member.Member;
import com.lecture.springbasic.member.MemberService;
import com.lecture.springbasic.order.Order;
import com.lecture.springbasic.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
