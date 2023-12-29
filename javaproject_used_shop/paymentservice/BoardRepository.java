package javaproject_used_shop.paymentservice;

import javaproject_used_shop.purchaseorder.memberRepository3;

public class BoardRepository {
    public interface PaymentService {

        void pay(memberRepository3.PurchaseOrder purchaseOrder);

    }
}
