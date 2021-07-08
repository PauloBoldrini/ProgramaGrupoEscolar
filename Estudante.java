package GrupoEscolar;

import java.io.Serializable;

public abstract class Estudante implements Serializable {


	private static final long serialVersionUID = 1L;
	//Atributos
	private int matricula;
	private String nome;
	private String responsavel;
	
	
	//Método Construtor
	public Estudante (int matricula, String nome, String responsavel) {
		this.matricula = matricula;
		this.nome = nome;
		this.responsavel = responsavel;
	}
	
	//toString Super
	public String toString() {
		String retorno = "";
		retorno += "Matrícula" + this.matricula + "\n";
		retorno += "Nome" + this.nome + "\n";
		retorno += "Resposável" + this.responsavel + "\n";
		return retorno;
	}
	
	//Métodos Get e Set
	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	

}
