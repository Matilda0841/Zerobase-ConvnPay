package com.zerobase.convpay.service;

import com.zerobase.convpay.type.*;

public class CardAdapter implements PaymentInterface{
  public void authorization(){
    System.out.println("authorization success.");

  }
  public void approval(){
    System.out.println("approval success.");
  }
  public CardResult capture(Integer payAmount){
    if (payAmount>100){
     return CardResult.USE_FAIL;
    }
    return CardResult.USE_SUCCESS;
  }
  public CardUseCancelResult cancelCapture(Integer cancelAmount){
    if (cancelAmount < 1000){
      return CardUseCancelResult.USE_CANCEL_FAIL;
    }
    return CardUseCancelResult.USE_CANCEL_SUCCESS;
  }

  @Override
  public PayMethodType getPayMethodType() {
    return PayMethodType.CARD;
  }

  @Override
  public PaymentResult payment(Integer payAmount) {
    authorization();
    approval();
    CardResult cardResult = capture(payAmount);

    if (cardResult == CardResult.USE_FAIL){
      return PaymentResult.PAYMENT_FAIL;
    }

    return PaymentResult.PAYMENT_SUCCESS;
  }

  @Override
  public CancelPaymentResult CancelPayment(Integer CancelAmount) {
    CardUseCancelResult cardUseCancelResult = cancelCapture(CancelAmount);

    if (cardUseCancelResult == CardUseCancelResult.USE_CANCEL_FAIL){
      return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
    }

    return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
  }
}
