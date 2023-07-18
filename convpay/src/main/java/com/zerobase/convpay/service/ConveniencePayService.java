package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

public class ConveniencePayService {// 편결이
  private final MoneyAdapter moneyAdapter = new MoneyAdapter();

  private final CardAdapter cardAdapter = new CardAdapter();


  // 나중에 여기에 포인트 결제를 추가할 때 포인트만 추가해서 더 만들 수 있게함
  // 이것이 인터페이스의 위력

  public PayResponse pay(PayRequest payRequest) { // 결제
    PaymentInterface paymentInterface;

    if (payRequest.getPayMethodType() == PayMethodType.CARD) {
      paymentInterface = cardAdapter;
    } else {
      paymentInterface = moneyAdapter;
    }

    PaymentResult payment = paymentInterface.payment(payRequest.getPayAmount());

    if (payment == PaymentResult.PAYMENT_FAIL) {
      return new PayResponse(PayResult.FAIL, 0);
    }

    return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    // SUCCESS CASE
    // SUCCESS 나 FAIL 을 IF문으로 하는 것은 피하는 방식/ 호불호나 선호도 문제
    // 중간에 FAIL문이 추가될 수 도 있기 때문에 단하나의 성공케이스를 제일 밑에다가 넣기

  }// 결제

  public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) { // 결제 취소
    PaymentInterface paymentInterface;

    if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
      paymentInterface = cardAdapter;
    } else {
      paymentInterface = moneyAdapter;
    }

    CancelPaymentResult cancelPaymentResult = paymentInterface.CancelPayment(payCancelRequest.getPayCancelAmount());

    if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
      return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
    }

    return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
  }// 결제 취소
}
