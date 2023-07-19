package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByMethodTest {
  DiscountByMethod discountByMethod = new DiscountByMethod();

  @Test
    void discountSuccess() {
    //given 어떤 데이터가 있을때
      PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25,1000);
      PayRequest payRequestCard = new PayRequest(PayMethodType.CARD, ConvenienceType.G25,1000);
    //when 어떤 동작을 하면
    Integer discountAmountMoney = discountByMethod.getDiscountAmount(payRequestMoney);
    Integer discountAmountCard = discountByMethod.getDiscountAmount(payRequestCard);
    //then 어떤 결과가 나와야 한다
    assertEquals(700,discountAmountMoney);
    assertEquals(1000,discountAmountCard);
  }
}