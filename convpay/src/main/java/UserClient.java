import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
  public static void main(String[] args) {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    ConveniencePayService conveniencePayService = applicationContext.getBean("conveniencePayService",ConveniencePayService.class);

    PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);
    PayResponse payResponse = conveniencePayService.pay(payRequest);

    System.out.println(payResponse);

    PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
    PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
    System.out.println(payCancelResponse);
  }
}
