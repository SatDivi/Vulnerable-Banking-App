package Banking.Banking.Payment.Service;

import Banking.Banking.Payment.Entity.UserData;
import Banking.Banking.Payment.Repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private UserDataRepository userDatarepository;

   /* @Autowired
    private EmiPyamentRequest emiPyamentRequest;*/

    public boolean processEmiAutoBebit(String accountNumber, String name, double debitAmount ) {
        //response from repository class query is amount in account, assign response to string variable and then compare with the request.getAmount

        Optional<UserData> userData=userDatarepository.findByAccountNumberAndName(accountNumber, name);
        if(userData.isPresent()) {
            UserData user = userData.get();
            double currentBalance = user.getAmount();
            if (currentBalance >= debitAmount) {
                user.setAmount(currentBalance - debitAmount);
                userDatarepository.save(user);
                return true;

            }
        }
        return false;

        }
    }


