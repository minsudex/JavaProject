package javaproject_used_shop.purchaseorder;

import javaproject_used_shop.product.memberRepository2;

import java.lang.reflect.Member;

public class memberRepository3 {
    public class PurchaseOrder {

        private final memberRepository3 member;
        private final memberRepository2.Product product;
        private final int quantity;
        private final int totalPrice;

        public PurchaseOrder(Member member, memberRepository2.Product product, int quantity) {
            this.member = (memberRepository3) member;
            this.product = product;
            this.quantity = quantity;
            this.totalPrice = product.getPrice() * quantity;
        }

        public Member getMember() {
            return (Member) member;
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
}
