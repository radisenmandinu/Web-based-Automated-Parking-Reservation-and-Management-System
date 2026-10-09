package Web_Based_Automated_Parking_Reservation_and_Management_System_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identifies the specific booking associated with the payment.
    @Column(nullable = false)
    private Long reservationId;

    // Identifies the user making the payment.
    @Column(nullable = false)
    private Long userId;

    // The payment amount.
    @Column(nullable = false)
    private Double amount;

    // The payment method used (eg:, CARD, PAYPAL).
    private String paymentMethod;

    // PENDING, SUCCESS, FAILED
    private String paymentStatus = "PENDING";

    // The timestamp when the payment was made.
    private LocalDateTime paymentDate;
}
