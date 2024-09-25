package Banking.Banking.Payment.Controller;


import Banking.Banking.Payment.DTO.EmiPaymentRequest;
import Banking.Banking.Payment.Entity.UserData;
import Banking.Banking.Payment.Service.PaymentService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class BankController {

    @Autowired
    private final PaymentService paymentService;

    public BankController(PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @PostMapping("/emi-autodebit")// it will request for autodebit from the user by taking parameters as account number and name
    public ResponseEntity<String> processEmiAutoDebit(@RequestBody EmiPaymentRequest request) {
        boolean isSuccess = paymentService.processEmiAutoBebit(request.getName(),request.getAccountNumber(), request.getDebitAmount());
        if (isSuccess) {
            return ResponseEntity.ok("EMI Auto Debit successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to process EMI Auto Debit ");
        }
    }
//@GetMapping("")
}
