package main.ffs;

import main.ffs.discount.DiscountPolicy;
import main.ffs.discount.FixDiscountPolicy;
import main.ffs.member.MemberService;
import main.ffs.member.MemberServiceImpl;
import main.ffs.member.MemoryMemberRepository;
import main.ffs.order.OrderService;
import main.ffs.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
