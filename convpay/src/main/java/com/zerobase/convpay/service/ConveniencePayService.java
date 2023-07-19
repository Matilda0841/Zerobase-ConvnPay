package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService {// 편결이
  private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap = new HashMap<>();
  private final DiscountInterface discountInterface;

  public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet, DiscountInterface discountInterface) {

    paymentInterfaceSet.forEach(
        paymentInterface -> paymentInterfaceMap.put(
          paymentInterface.getPayMethodType(),paymentInterface
        )
    );
    this.discountInterface = discountInterface;
  }

  // 나중에 여기에 포인트 결제를 추가할 때 포인트만 추가해서 더 만들 수 있게함
  // 이것이 인터페이스의 위력

  public PayResponse pay(PayRequest payRequest) { // 결제
    PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());


    Integer discountedAmount = discountInterface.getDiscountAmount(payRequest);
    PaymentResult payment = paymentInterface.payment(discountedAmount);

    if (payment == PaymentResult.PAYMENT_FAIL) {
      return new PayResponse(PayResult.FAIL, 0);
    }

    return new PayResponse(PayResult.SUCCESS, discountedAmount);
    // SUCCESS CASE
    // SUCCESS 나 FAIL 을 IF문으로 하는 것은 피하는 방식/ 호불호나 선호도 문제
    // 중간에 FAIL문이 추가될 수 도 있기 때문에 단하나의 성공케이스를 제일 밑에다가 넣기

  }// 결제

  public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) { // 결제 취소
    PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

    CancelPaymentResult cancelPaymentResult = paymentInterface.CancelPayment(payCancelRequest.getPayCancelAmount());

    if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
      return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
    }

    return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
  }// 결제 취소
}
