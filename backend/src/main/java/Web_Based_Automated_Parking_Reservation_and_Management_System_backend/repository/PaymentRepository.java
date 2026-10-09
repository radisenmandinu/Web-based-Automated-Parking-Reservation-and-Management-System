package Web_Based_Automated_Parking_Reservation_and_Management_System_backend.repository;

import Web_Based_Automated_Parking_Reservation_and_Management_System_backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Retrieves all payment records for a specific user.
    List<Payment> findByUserId(Long userId);

    // Retrieves the payment record for a specific booking.
    Payment findByReservationId(Long reservationId);
}
