package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.MoneyUseCanCelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PaymentResult;

public class MoneyAdapter implements PaymentInterface{
  public MoneyUseResult use(Integer payAmount){ // 사용
    System.out.println("MoneyAdapter.use : " + payAmount);

    if (payAmount>1000_000){
      return MoneyUseResult.USE_FAIL;
    }

    return MoneyUseResult.USE_SUCCESS;
  }// 사용
  public MoneyUseCanCelResult useCancel(Integer payCancelAmount){
    System.out.println("MoneyAdapter.useCancel : " + payCancelAmount);

    if (payCancelAmount < 100){
      return MoneyUseCanCelResult.MONEY_USE_CAN_CEL_FAIL;
    }

    return MoneyUseCanCelResult.MONEY_USE_CAN_CEL_SUCCESS;

  }// 사용 취소

  @Override
  public PaymentResult payment(Integer payAmount) {
    MoneyUseResult moneyUseResult = use(payAmount);

    if (moneyUseResult == MoneyUseResult.USE_FAIL){
      return PaymentResult.PAYMENT_FAIL;
    }

    return PaymentResult.PAYMENT_SUCCESS;
  }

  @Override
  public CancelPaymentResult CancelPayment(Integer cancelAmount) {
    MoneyUseCanCelResult moneyUseCanCelResult = useCancel(cancelAmount);
    if (moneyUseCanCelResult == MoneyUseCanCelResult.MONEY_USE_CAN_CEL_FAIL){
      return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
    }
    return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
  }
}
