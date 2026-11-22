import java.math.BigDecimal;
import java.time.LocalDate;

public class Receita extends Transacao {
	public Receita(
			String nome,
			String descricao,
		    BigDecimal valor,
		    LocalDate data,
		    CategoriaTransacao categoria
			) {
				super(nome, descricao, valor, data, categoria);
			};
}
