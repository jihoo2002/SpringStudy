package helllo.core.order;

import helllo.core.discount.DiscountPolicy;
import helllo.core.discount.FixDiscountPolicy;
import helllo.core.discount.RateDiscountPolicy;
import helllo.core.member.Member;
import helllo.core.member.MemberRepository;
import helllo.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*
    orderServiceImpl은 현재 인터페이스뿐만 아니라 아래 구현체에도 의존, DIP 위반
      private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
      private final DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
