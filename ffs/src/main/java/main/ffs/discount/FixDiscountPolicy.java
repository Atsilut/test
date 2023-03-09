package main.ffs.discount;

import main.ffs.member.Grade;
import main.ffs.member.Member;

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
