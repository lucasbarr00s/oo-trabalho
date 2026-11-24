package controlegastos.modelo;
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Transacao {
    // static - atributo pertence a classe
	private static int proximoId = 1;

	private int id;
	
	protected String nome;
	protected String descricao;
	protected BigDecimal valor;
	protected LocalDate data;
	protected CategoriaTransacao categoria;
	
	protected Transacao (
			String nome,
			String descricao,
			BigDecimal valor,
			LocalDate data,
			CategoriaTransacao categoria
	) {
        // atribuicao do proximoId no Id de cada objeto Transacao
		this.id = proximoId++;

		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.categoria = categoria;
	}

	protected Transacao(
            int idExistente,
            String nome,
            String descricao,
            BigDecimal valor,
            LocalDate data,
            CategoriaTransacao categoria) {
        this.id = idExistente;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

	public String getNome() {
	    return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
	    return valor;
	}

	public CategoriaTransacao getCategoria() {
	    return categoria;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public int getId() {
	    return id;
	}
	
	
}
