package controlegastos.modelo;
public enum CategoriaTransacao {
    SALARIOS(TipoTransacao.RECEITA),
    HONORARIOS(TipoTransacao.RECEITA),
    RENDIMENTOS(TipoTransacao.RECEITA),
    OUTRAS_RECEITAS(TipoTransacao.RECEITA),
    
    MORADIA(TipoTransacao.DESPESA),
    LUZ(TipoTransacao.DESPESA),
    AGUA(TipoTransacao.DESPESA),
    COMUNICACOES(TipoTransacao.DESPESA),
    ALIMENTACAO(TipoTransacao.DESPESA),
    TRANSPORTE(TipoTransacao.DESPESA),
    SAUDE(TipoTransacao.DESPESA),
    EDUCACAO(TipoTransacao.DESPESA),
    LAZER(TipoTransacao.DESPESA),
    OUTRAS_DESPESAS(TipoTransacao.DESPESA);
	
	private final TipoTransacao tipo;
	
	CategoriaTransacao(TipoTransacao tipo) {
		this.tipo = tipo;
	}
	
	public TipoTransacao getTipo() {
		return tipo;
	}
}
