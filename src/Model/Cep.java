package Model;

public class Cep {
    private String cep;
    private String logradouro;
    private String complemento;
    private String localidade;
    private String uf;
    private String regiao;

    public Cep(Endereco endereco) {
        cep = endereco.cep();
        logradouro = endereco.logradouro();
        complemento = endereco.complemento();
        localidade = endereco.localidade();
        uf = endereco.uf();
        regiao = endereco.regiao();
    }

    @Override
    public String toString() {
        return String.format(
                "Cep: %s;\nlogradouro: %s;\ncomplemento: %s;\nlocalidade: %s;\nuf: %s;\nregiao: %s",
                cep, logradouro, complemento, localidade, uf, regiao);
    }
}
