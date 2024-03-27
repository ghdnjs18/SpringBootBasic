package com.lecture.springbasic.order;

import com.lecture.springbasic.discount.DiscountPolicy;
import com.lecture.springbasic.discount.FixDiscountPolicy;
import com.lecture.springbasic.discount.RateDiscountPolicy;
import com.lecture.springbasic.member.Member;
import com.lecture.springbasic.member.MemberRepository;
import com.lecture.springbasic.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    // 구현 클래스에도 의존을 하고 있다 -> DIP 위반
    // 구현 클래스가 변경되면 클라이언트를 수정 해야 한다. -> OCP를 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 초기화를 하지 않으면 구현 클래스에 의존하지 않고 인터페이스에만 의존한다. -> DIP 성립
    private final DiscountPolicy discountPolicy;

    // 생성자를 통해 구현 객체가 주입되어 클라이언트에서 수정할 필요가 없다. -> OCP 성립
    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
