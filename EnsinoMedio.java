package GrupoEscolar;

public class EnsinoMedio extends Estudante {

	private static final long serialVersionUID = 1L;
	//Atributos - Oficinas proficionalizantes
	public String oficinasProficionalizantes;
	public String computacao;
	public String marcenaria;
	public String contabilidade;
	
	
	//Método Construtor	
	public EnsinoMedio(String nome, int matricula, String responsavel, String oficinasProficionalizantes, String computacao, String marcenaria, String contabilidade) {
		super(matricula, nome, responsavel);
		this.oficinasProficionalizantes = oficinasProficionalizantes;
		this.computacao = computacao;
		this.marcenaria = marcenaria;
		this.contabilidade = contabilidade;
		
		

	}

	//toString Super
	public String toString() {
		String retorno = "";
		retorno += "Matrícula: " + this.getMatricula() + "\n";
		retorno += "Nome: " + this.getNome() + "\n";
		retorno += "Resposável: " + this.getResponsavel() + "\n";
		retorno += "Realiza oficina Proficionalizante: " + this.oficinasProficionalizantes + "\n";
		retorno += "Faz aula de computação: " + this.computacao + "\n";
		retorno += "Faz aula de marcenaria: " + this.marcenaria + "\n";
		retorno += "Faz aula de contabilidade: " + this.contabilidade + "\n";
		return retorno;
		
	}



	//Métodos Get e Set
	public String getOficinasProficionalizantes() {
		return oficinasProficionalizantes;
	}

	public void setOficinasProficionalizantes(String oficinasProficionalizantes) {
		this.oficinasProficionalizantes = oficinasProficionalizantes;
	}

	public String getComputacao() {
		return computacao;
	}

	public void setComputacao(String computacao) {
		this.computacao = computacao;
	}

	public String getMarcenaria() {
		return marcenaria;
	}

	public void setMarcenaria(String marcenaria) {
		this.marcenaria = marcenaria;
	}

	public String getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(String contabilidade) {
		this.contabilidade = contabilidade;
	}


	
	
}
