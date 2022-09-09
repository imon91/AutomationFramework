package repository.remoteRepo.responseRepo;

public class UpdateDateResponseClass {

    /**
     * is_closed : false
     * status : PENDING
     * owner_id : 599bd7f1ccab55b020bb1147
     * external_id : va_fixed-123
     * bank_code : MANDIRI
     * merchant_code : 88608
     * name : tasnim
     * account_number : 886088018127249
     * is_single_use : false
     * expiration_date : 2053-10-07T17:00:00.000Z
     * id : 6319db1cd77df50bc10a9713
     */

    private boolean is_closed;
    private String status;
    private String owner_id;
    private String external_id;
    private String bank_code;
    private String merchant_code;
    private String name;
    private String account_number;
    private boolean is_single_use;
    private String expiration_date;
    private String id;
    private String error_code;
    private String message;
    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getMerchant_code() {
        return merchant_code;
    }

    public void setMerchant_code(String merchant_code) {
        this.merchant_code = merchant_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public boolean isIs_single_use() {
        return is_single_use;
    }

    public void setIs_single_use(boolean is_single_use) {
        this.is_single_use = is_single_use;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}
