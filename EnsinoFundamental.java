package GrupoEscolar;

public class EnsinoFundamental extends Estudante{

	private static final long serialVersionUID = 1L;
	//Atributos - Atividade Contraturno
	public String atividadeContraturno;
	public String natacao;
	public String judo;
	public String ginastica;
	
	//Método Construtor	
	public EnsinoFundamental(String nome, int matricula, String responsavel, String atividadeContraturno, String natacao, String judo, String ginastica) {
		super(matricula, nome, responsavel);
		this.atividadeContraturno = atividadeContraturno;
		this.natacao = natacao;
		this.judo = judo;
		this.ginastica = ginastica;
	}
	
	//toString Super
	public String toString() {
		String retorno = "";
		retorno += "Matrícula: " + this.getMatricula() + "\n";
		retorno += "Nome: " + this.getNome() + "\n";
		retorno += "Resposável: " + this.getResponsavel() + "\n";
		retorno += "Realiza atividade no Contraturno: " + this.atividadeContraturno + "\n";
		retorno += "Faz natação: " + this.natacao + "\n";
		retorno += "Faz judô: " + this.judo + "\n";
		return retorno;
		
	}



	//Métodos Get e Set
	public String getAtividadeContraturno() {
		return atividadeContraturno;
	}

	public void setAtividadeContraturno(String atividadeContraturno) {
		this.atividadeContraturno = atividadeContraturno;
	}

	public String getNatacao() {
		return natacao;
	}

	public void setNatacao(String natacao) {
		this.natacao = natacao;
	}

	public String getJudo() {
		return judo;
	}

	public void setJudo(String judo) {
		this.judo = judo;
	}

	public String getGinastica() {
		return ginastica;
	}

	public void setGinastica(String ginastica) {
		this.ginastica = ginastica;
	}
	



	
	
	
	
}

	
	
	