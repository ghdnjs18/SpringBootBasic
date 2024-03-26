package com.lecture.springbasic;

import com.lecture.springbasic.discount.FixDiscountPolicy;
import com.lecture.springbasic.member.MemberService;
import com.lecture.springbasic.member.MemoryMemberRepository;
import com.lecture.springbasic.member.memberServiceImpl;
import com.lecture.springbasic.order.OrderService;
import com.lecture.springbasic.order.OrderServiceImpl;

// 애플리케이션의 전체 동작 방식을 구성하기 위해, 구현 객체를 생성하고,
// 연결하는 책임을 가지는 별도의 설정 클래스가 등장한다.
public class AppConfig {

    public MemberService memberService() {
        return new memberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
