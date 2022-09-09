package repository.remoteRepo.responseRepo;

public class PaymentVAResponseClass {

    /**
     * status : COMPLETED
     * message : Payment for the Fixed VA with external id va_fixed-123 is currently being processed. Please ensure that you have set a callback URL for VA payments via Dashboard Settings and contact us if you do not receive a VA payment callback within the next 5 mins.
     */

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
