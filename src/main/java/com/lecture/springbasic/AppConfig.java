package com.lecture.springbasic;

import com.lecture.springbasic.discount.DiscountPolicy;
import com.lecture.springbasic.discount.RateDiscountPolicy;
import com.lecture.springbasic.member.MemberRepository;
import com.lecture.springbasic.member.MemberService;
import com.lecture.springbasic.member.MemoryMemberRepository;
import com.lecture.springbasic.member.MemberServiceImpl;
import com.lecture.springbasic.order.OrderService;
import com.lecture.springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션의 전체 동작 방식을 구성하기 위해, 구현 객체를 생성하고,
// 연결하는 책임을 가지는 별도의 설정 클래스가 등장한다.
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    // 구성 정보에서 역할과 구현을 명확하게 분리해 역할이 잘 드러나고 중복을 제거함
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
