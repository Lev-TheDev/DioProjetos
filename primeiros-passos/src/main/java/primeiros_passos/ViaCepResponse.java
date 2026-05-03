package primeiros_passos;

public class ViaCepResponse {
    private String cep;
    private String street;
    private String local;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "ViaCepResponse{" +
                "cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
