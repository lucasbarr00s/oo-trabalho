import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Transacao {
    // static - atributo pertence a classe
	private static int proximoId = 1;

	private int id;
	
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;
	private CategoriaTransacao categoria;
	
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
	};
	
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
