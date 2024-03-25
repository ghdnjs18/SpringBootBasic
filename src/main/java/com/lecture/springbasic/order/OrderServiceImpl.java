package com.lecture.springbasic.order;

import com.lecture.springbasic.discount.DiscountPolicy;
import com.lecture.springbasic.discount.FixDiscountPolicy;
import com.lecture.springbasic.member.Member;
import com.lecture.springbasic.member.MemberRepository;
import com.lecture.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
