package com.lecture.springbasic.order;

import com.lecture.springbasic.AppConfig;
import com.lecture.springbasic.discount.DiscountPolicy;
import com.lecture.springbasic.discount.FixDiscountPolicy;
import com.lecture.springbasic.member.Grade;
import com.lecture.springbasic.member.Member;
import com.lecture.springbasic.member.MemberService;
import com.lecture.springbasic.member.memberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("주문과 할인 정책 테스트")
    void createOrder() {
        // given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}