package repository.remoteRepo.requestRepo;

public class CreateVARequestClass {

    /**
     * external_id : va-1475804036622
     * bank_code : MANDIRI
     * name : Michael Chen
     */

    private String external_id;
    private String bank_code;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
