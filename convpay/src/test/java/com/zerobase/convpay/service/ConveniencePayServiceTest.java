package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.ConvenienceType;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.dto.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
  ConveniencePayService conveniencePayService =  new ConveniencePayService();


  @Test
    void pay_success(){
      //given 어떤 데이터가 있을때
    PayRequest payRequest = new PayRequest(ConvenienceType.G25,100);
      //when 어떤 동작을 하면
    PayResponse payResponse = ConveniencePayService.pay(payRequest);
    //then 어떤 결과가 나와야 한다
    assertEquals(PayResult.SUCCESS,payResponse.getPayResult());
    assertEquals(100,payResponse.getPaidAmount());
  }

}