package helllo.core.discount;

import helllo.core.member.Member;

public interface DiscountPolicy {
    
    /*
    @return 할인 대상 금액 (1000원 할인 등)
     */
    int discount(Member member, int price);
}
