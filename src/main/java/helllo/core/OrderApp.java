package helllo.core;

import helllo.core.member.Grade;
import helllo.core.member.Member;
import helllo.core.member.MemberService;
import helllo.core.member.MemberServiceImpl;
import helllo.core.order.Order;
import helllo.core.order.OrderService;
import helllo.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculateDiscount() = " + order.calculateDiscount());

    }
}
