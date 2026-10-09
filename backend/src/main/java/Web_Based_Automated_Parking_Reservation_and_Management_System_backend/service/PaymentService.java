package Web_Based_Automated_Parking_Reservation_and_Management_System_backend.service;

import Web_Based_Automated_Parking_Reservation_and_Management_System_backend.entity.Payment;
import Web_Based_Automated_Parking_Reservation_and_Management_System_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Processes a payment transaction.
    public Payment processPayment(Payment payment) {
        // The system automatically sets the current time and success status.
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentStatus("SUCCESS");
        return paymentRepository.save(payment);
    }

    // Retrieves the payment records for a specific user.
    public List<Payment> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    // Retrieves the payment details associated with a specific booking.
    public Payment getPaymentByReservation(Long reservationId) {
        return paymentRepository.findByReservationId(reservationId);
    }
}
