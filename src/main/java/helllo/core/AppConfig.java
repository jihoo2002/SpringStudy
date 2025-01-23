package helllo.core;

import helllo.core.discount.DiscountPolicy;
import helllo.core.discount.FixDiscountPolicy;
import helllo.core.discount.RateDiscountPolicy;
import helllo.core.member.MemberRepository;
import helllo.core.member.MemberService;
import helllo.core.member.MemberServiceImpl;
import helllo.core.member.MemoryMemberRepository;
import helllo.core.order.OrderService;
import helllo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
