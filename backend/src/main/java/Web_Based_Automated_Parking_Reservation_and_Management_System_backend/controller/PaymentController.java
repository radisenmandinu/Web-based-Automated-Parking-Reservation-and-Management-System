package Web_Based_Automated_Parking_Reservation_and_Management_System_backend.controller;

import Web_Based_Automated_Parking_Reservation_and_Management_System_backend.entity.Payment;
import Web_Based_Automated_Parking_Reservation_and_Management_System_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // API endpoint for processing payments.
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.processPayment(payment));
    }

    // API endpoint to retrieve a user's payment history.
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> getUserPayments(@PathVariable Long userId) {
        return ResponseEntity.ok(paymentService.getPaymentsByUser(userId));
    }

    // API endpoint to retrieve the payment details for a specific booking.
    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<Payment> getPaymentByReservation(@PathVariable Long reservationId) {
        return ResponseEntity.ok(paymentService.getPaymentByReservation(reservationId));
    }
}
