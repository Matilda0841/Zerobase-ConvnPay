package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
  DiscountByConvenience discountByConvenience = new DiscountByConvenience();

  @Test
  void discountTest() {
    //given 어떤 데이터가 있을때
    PayRequest payRequestG25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
    PayRequest payRequestGU = new PayRequest(PayMethodType.MONEY, ConvenienceType.GU, 1000);
    PayRequest payRequestSeven = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN, 1000);


    //when 어떤 동작을 하면
    Integer discountAmountG25 = discountByConvenience.getDiscountAmount(payRequestG25);
    Integer discountAmountGU = discountByConvenience.getDiscountAmount(payRequestGU);
    Integer discountAmountSEVEN = discountByConvenience.getDiscountAmount(payRequestSeven);
    //then 어떤 결과가 나와야 한다
    assertEquals(800, discountAmountG25);
    assertEquals(900, discountAmountGU);
    assertEquals(1000, discountAmountSEVEN);
  }

}