package com.lecture.springbasic.order;

import com.lecture.springbasic.discount.DiscountPolicy;
import com.lecture.springbasic.discount.FixDiscountPolicy;
import com.lecture.springbasic.discount.RateDiscountPolicy;
import com.lecture.springbasic.member.Member;
import com.lecture.springbasic.member.MemberRepository;
import com.lecture.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 구현 클래스에도 의존을 하고 있다 -> DIP 위반
    // 클라이언트를 수정 해야 한다. -> OCP를 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 초기화를 하지 않으면 구현 클래스에 의존하지 않는다. -> DIP 성립
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
