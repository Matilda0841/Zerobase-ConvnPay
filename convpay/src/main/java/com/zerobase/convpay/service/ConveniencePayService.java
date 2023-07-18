package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.MoneyUseCanCelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayResult;

public class ConveniencePayService {// 편결이

  private final MoneyAdapter moneyAdapter = new MoneyAdapter();
  public PayResponse pay(PayRequest payRequest){ // 결제
    MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());
    if (moneyUseResult == MoneyUseResult.USE_FAIL) {
      return new PayResponse(PayResult.FAIL, 0);
    }

    // SUCCESS CASE
      return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
      // SUCCESS 나 FAIL 을 IF문으로 하는 것은 피하는 방식/ 호불호나 선호도 문제
      // 중간에 FAIL문이 추가될 수 도 있기 때문에 단하나의 성공케이스를 제일 밑에다가 넣기

  }// 결제
  public PayCancelResponse payCancel(PayCancelRequest payCancelRequest){ // 결제 취소
    MoneyUseCanCelResult moneyUseCanCelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

    if (moneyUseCanCelResult == MoneyUseCanCelResult.MONEY_USE_CAN_CEL_FAIL){
      return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL,0);
    }

    // SUCCESS CASE
    return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
  }// 결제 취소
}
