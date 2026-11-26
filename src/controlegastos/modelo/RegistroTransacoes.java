package controlegastos.modelo;

import java.math.BigDecimal;
import java.util.List;

public interface RegistroTransacoes {
    void inserirTransacao(Transacao transacao);
    void atualizarTransacao(int id, Transacao transacao);
    void removerTransacao(int id);
    BigDecimal consultarSaldo();
    List<Transacao> getTransacoes();
}
