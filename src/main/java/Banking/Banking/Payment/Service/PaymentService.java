package Banking.Banking.Payment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

   /* @Autowired
    private EmiPyamentRequest emiPyamentRequest;*/

    public boolean processEmiAutoBebit(EmiPyamentRequest request) {
        //response from repository class query is amount in account, assign response to string variable and then compare with the request.getAmount
        if (request.getAmount() > 0) {
            return true;
        } else
            return false;
    }
}

