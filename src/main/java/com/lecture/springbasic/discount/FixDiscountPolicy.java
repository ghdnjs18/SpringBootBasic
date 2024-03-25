package com.lecture.springbasic.discount;

import com.lecture.springbasic.member.Grade;
import com.lecture.springbasic.member.Member;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
