package com.lecture.springbasic.discount;

import com.lecture.springbasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
