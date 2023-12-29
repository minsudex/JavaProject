package javaproject_used_shop.salesorder;

import javaproject_used_shop.product.memberRepository2;

import java.lang.reflect.Member;

public class BoardRepository {
    private Member member;
    private memberRepository2.Product product;
    private int quantity;
    private int totalPrice;

    public void SalesOrder(Member member, memberRepository2.Product product, int quantity) {
        this.member = member;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public Member getMember() {
        return member;
    }

    public memberRepository2.Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}


