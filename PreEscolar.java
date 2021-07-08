package GrupoEscolar;

public class PreEscolar extends Estudante{

	private static final long serialVersionUID = 1L;
	//Atributos - Cuidados
	public String necessidadeCuidados;
	public String alergia;
	public String remedio;
	
	
	//Método Construtor
	//Exemplo
	//public Cao(String nome, int idade, String dono) {
		//super(nome, idade, dono);
		//this.especie = "Cachorro";
	public PreEscolar(String nome, int matricula, String responsavel, String necessidadeCuidados, String alergia, String remedio) {
		super(matricula, nome, responsavel);
		this.necessidadeCuidados = necessidadeCuidados;
		this.alergia = alergia;
		this.remedio = remedio;
	}

	//toString Super
	public String toString() {
		String retorno = "";
		retorno += "Matrícula: " + this.getMatricula() + "\n";
		retorno += "Nome: " + this.getNome() + "\n";
		retorno += "Resposável: " + this.getResponsavel() + "\n";
		retorno += "Necessita de cuidados: " + this.necessidadeCuidados + "\n";
		retorno += "Alergia: " + this.alergia + "\n";
		retorno += "Utiliza medicamento: " + this.remedio + "\n";
		
		
		return retorno;
	}



	//Métodos Get e Set
	public String getNecessidadeCuidados() {
		return necessidadeCuidados;
	}


	public void setNecessidadeCuidados(String necessidadeCuidados) {
		this.necessidadeCuidados = necessidadeCuidados;
	}


	public String getAlergia() {
		return alergia;
	}


	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}


	public String getRemedio() {
		return remedio;
	}


	public void setRemedio(String remedio) {
		this.remedio = remedio;
	}


	
	
	
}
