package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;

public class DiscountByMethod implements DiscountInterface{
  @Override
  public Integer getDiscountAmount(PayRequest payRequest) {
    switch (payRequest.getPayMethodType()) {
      case MONEY : {
        return payRequest.getPayAmount()*7/10;
      }
      case CARD : {
        return payRequest.getPayAmount();
      }
    }
    return payRequest.getPayAmount();
  }
}
