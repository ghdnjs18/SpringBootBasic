package com.lecture.springbasic.discount;

import com.lecture.springbasic.annotation.MainDiscountPolicy;
import com.lecture.springbasic.member.Grade;
import com.lecture.springbasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}
