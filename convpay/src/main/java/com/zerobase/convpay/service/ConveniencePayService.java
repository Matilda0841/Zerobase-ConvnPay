package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.dto.PayResult;

public class ConveniencePayService {// 편결이
  public static PayResponse pay(PayRequest payRequest){ // 결제
    return new PayResponse(PayResult.SUCCESS,100);
  }// 결제
  public void payCancel(){ // 결제 취소

  }// 결제 취소
}
