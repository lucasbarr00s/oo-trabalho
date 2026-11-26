package controlegastos.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conta implements RegistroTransacoes {
    private Titular titular;
    private List<Transacao> transacoes;
    private BigDecimal saldo;
    
    public Conta(Titular titular) {
        this.titular = titular;
        this.transacoes = new ArrayList<>();
        this.saldo = BigDecimal.ZERO;
    }

    @Override 
    public List<Transacao> getTransacoes() {
        List<Transacao> copia = new ArrayList<>(transacoes);
        return copia;
    }

    public Titular getTitular() {
        return titular;
    }

    @Override 
    public BigDecimal consultarSaldo() {
        return saldo;
    }

    private int buscarIndice(int id) {
        for (int i = 0; i < transacoes.size(); i++) {
            if (transacoes.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override 
    public void inserirTransacao(Transacao transacao){
        BigDecimal novoSaldo = saldo.add(calcularEfeito(transacao));
        if (novoSaldo.compareTo(BigDecimal.ZERO) < 0 ) {
            return;   //saldoInsuficienteException (P3)
        }
        transacoes.add(transacao);
        this.saldo = novoSaldo;
    }
    
    @Override 
    public void atualizarTransacao(int id, Transacao transacao) {
        int indice = buscarIndice(id);
        if (indice < 0) {
            return; //transacao nao encontrada 
        }
        Transacao antiga = transacoes.get(indice);
        BigDecimal novoSaldo = saldo.subtract(calcularEfeito(antiga)).add(calcularEfeito(transacao));
        if (novoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            return; //saldoInsuficienteException (P3)
        }
        transacoes.set(indice, transacao);
        this.saldo = novoSaldo;
    }

    @Override 
    public void removerTransacao(int id) {
        int indice = buscarIndice(id);
        if (indice < 0) {
            return; //transacao nao encontrada (P3)
        }
        Transacao removida = transacoes.get(indice);
        BigDecimal novoSaldo = saldo.subtract(calcularEfeito(removida));
        if (novoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            return; //(saldoInsuficienteException (P3)
        }
        transacoes.remove(indice);
        this.saldo = novoSaldo;
    }

    private BigDecimal calcularEfeito(Transacao transacao) {
        if (transacao instanceof Receita) {
            return transacao.getValor();
        } 
        else {
            return transacao.getValor().negate();
        }
    }
}
