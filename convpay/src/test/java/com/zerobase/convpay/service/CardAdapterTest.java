package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CardResult;
import com.zerobase.convpay.type.CardUseCancelResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {
  private CardAdapter cardAdapter = new CardAdapter();
      @Test
          void capture_success(){
              //given 어떤 데이터가 있을때
        Integer payAmount  = 99;
              //when 어떤 동작을 하면
        CardResult cardResult = cardAdapter.capture(payAmount);
              //then 어떤 결과가 나와야 한다
        assertEquals(CardResult.USE_SUCCESS,cardResult);
          }
      @Test
          void capture_fail(){
              //given 어떤 데이터가 있을때
        Integer payAmount  = 101;
              //when 어떤 동작을 하면
        CardResult cardResult = cardAdapter.capture(payAmount);
              //then 어떤 결과가 나와야 한다
        assertEquals(CardResult.USE_FAIL,cardResult);
          }
      @Test
          void cancel_capture_success(){
              //given 어떤 데이터가 있을때
        Integer payAmount  = 1001;
              //when 어떤 동작을 하면
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(payAmount);
        //then 어떤 결과가 나와야 한다
        assertEquals(CardUseCancelResult.USE_CANCEL_SUCCESS,cardUseCancelResult);
          }
      @Test
          void cancel_capture_fail(){
              //given 어떤 데이터가 있을때
        Integer payAmount  = 999;
              //when 어떤 동작을 하면
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(payAmount);
        //then 어떤 결과가 나와야 한다
        assertEquals(CardUseCancelResult.USE_CANCEL_FAIL,cardUseCancelResult);
          }

}