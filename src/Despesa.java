import java.math.BigDecimal;
import java.time.LocalDate;

public class Despesa extends Transacao {
	public Despesa(
			String nome,
			String descricao,
		    BigDecimal valor,
		    LocalDate data,
		    CategoriaTransacao categoria			
		) {
			super(nome, descricao, valor, data, categoria);
		}
}

