package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCanCelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import org.junit.jupiter.api.Test;

import static com.zerobase.convpay.type.MoneyUseResult.USE_FAIL;
import static com.zerobase.convpay.type.MoneyUseResult.USE_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {
    MoneyAdapter moneyAdapter = new MoneyAdapter();
    @Test
      void moneyUseFail(){
          //given 어떤 데이터가 있을때
      Integer payAmount = 1000_001;
          //when 어떤 동작을 하면
      MoneyUseResult moneyUseResult =  moneyAdapter.use(payAmount);
          //then 어떤 결과가 나와야 한다
      assertEquals(USE_FAIL, moneyUseResult);
      }
    @Test
      void moneyUseSuccess(){
          //given 어떤 데이터가 있을때
      Integer payAmount = 1000_000;
          //when 어떤 동작을 하면
      MoneyUseResult moneyUseResult =  moneyAdapter.use(payAmount);
          //then 어떤 결과가 나와야 한다
      assertEquals(USE_SUCCESS, moneyUseResult);
    }

    @Test
      void moneyUseCancelSuccess(){
          //given 어떤 데이터가 있을때
      Integer payCancelAmount = 101;
          //when 어떤 동작을 하면
      MoneyUseCanCelResult moneyUseCanCelResult = moneyAdapter.useCancel(payCancelAmount);
          //then 어떤 결과가 나와야 한다
      assertEquals(MoneyUseCanCelResult.MONEY_USE_CAN_CEL_SUCCESS, moneyUseCanCelResult);
      }
    @Test
      void moneyUseCancelFail(){
          //given 어떤 데이터가 있을때
      Integer payCancelAmount = 99;
          //when 어떤 동작을 하면
      MoneyUseCanCelResult moneyUseCanCelResult = moneyAdapter.useCancel(payCancelAmount);
          //then 어떤 결과가 나와야 한다
      assertEquals(MoneyUseCanCelResult.MONEY_USE_CAN_CEL_FAIL, moneyUseCanCelResult);
      }
}