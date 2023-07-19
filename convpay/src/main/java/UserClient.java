import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class UserClient {
  public static void main(String[] args) {

    ApplicationConfig applicationConfig =  new ApplicationConfig();
    ConveniencePayService conveniencePayService = applicationConfig.conveniencePayServiceDiscountPayMethod();

    PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);
    PayResponse payResponse = conveniencePayService.pay(payRequest);

    System.out.println(payResponse);

    PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
    PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
    System.out.println(payCancelResponse);
  }
}
