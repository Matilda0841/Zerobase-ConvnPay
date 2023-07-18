package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCanCelResult;
import com.zerobase.convpay.type.MoneyUseResult;

public class MoneyAdapter {
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

}
