package GrupoEscolar;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class GrupoEscolar {

	
	private ArrayList<Estudante> estudante;

	public GrupoEscolar() {
		this.estudante = new ArrayList<Estudante>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  (" " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public PreEscolar lePreEscolar (){

		String [] valores = new String [0];
		String [] nomeVal = {"Nome ", "Matricula ", "Responsável ", "Necessita de cuidados(sim/não)", "Possui alergia(sim/não)", "Utiliza algum medicamento(sim/não)"};
		valores = leValores (nomeVal);


		int matricula = this.retornaInteiro(valores[1]);


		PreEscolar preEscolar = new PreEscolar (valores[0], matricula, valores[2], valores[3], valores[4], valores[5]);
		return preEscolar;
	}

	public EnsinoFundamental leEnsinoFundamental (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome ", "Matricula ", "Responsável "};
		valores = leValores (nomeVal);

		int matricula = this.retornaInteiro (valores[1]);

		EnsinoFundamental ensinoFundamental = new EnsinoFundamental (valores[0], matricula, valores[2], valores[3], valores[4], valores[5], valores[6]);
		return ensinoFundamental;
	}
	
	public EnsinoMedio leEnsinoMedio (){

		String [] valores = new String [0];
		String [] nomeVal = {"Nome ", "Matricula ", "Responsável "};
		valores = leValores (nomeVal);

		int matricula = this.retornaInteiro(valores[1]);

		EnsinoMedio ensinoMedio = new EnsinoMedio (valores[0], matricula, valores[2], valores[3], valores[4], valores[5], valores[6]);
		return ensinoMedio;
	}


	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // M�todo est�tico, que tenta tranformar uma string em double
			return true;
		} catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor double


		//Enquanto n�o for poss�vel converter o valor de entrada para double, permanece no loop
		while(!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto! Digite um número inteiro");
		}
		return Integer.parseInt(entrada);
	}
	

	
	public void salvaEstudante (ArrayList<Estudante> estudante){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\grupoEscolar.dados"));
			for (int i=0; i < estudante.size(); i++)
				outputStream.writeObject(estudante.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Estudante> recuperaEstudante (){
		ArrayList<Estudante> estudanteTemp = new ArrayList<Estudante>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\grupoEscolar.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Estudante) {
					estudanteTemp.add((Estudante) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com estudantes NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return estudanteTemp;
		}
	}
	
	//Menu Grupo Escolar
	public void menuGrupoEscolar (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Grupo Escolar\n" +
					"Opções:\n" + 
					"1. Entrar em um perfil de estudante\n" +
					"2. Exibir um perfil de um estudante\n" +
					"3. Limpar o perfil de um estudante\n" +
					"4. Gravar o perfil de um estudante\n" +
					"5. Recuperar o perfil de um estudante\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);
	
			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrar em um perfil de estudante\n" +
						"Opções:\n" + 
						"1. Pré-Escola\n" +
						"2. Ensino Fundamental\n" +
						"3. Ensino Médio";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: estudante.add((Estudante)lePreEscolar());
				break;
				case 2: estudante.add((Estudante)leEnsinoFundamental());
				break;
				case 3: estudante.add((Estudante)leEnsinoMedio());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Tipo de perfil de estudante não definido");
				}

				break;
			case 2: // Exibir dados
				if (estudante.size() == 0) {
					JOptionPane.showMessageDialog(null,"Primeiro, entre com o perfil de estudante escolhido");
					break;
				}
				String dados = "";
				for (int i=0; i < estudante.size(); i++)	{
					dados += estudante.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (estudante.size() == 0) {
					JOptionPane.showMessageDialog(null,"Primeiro, entre com o perfil de estudante escolhido");
					break;
				}
				estudante.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (estudante.size() == 0) {
					JOptionPane.showMessageDialog(null,"Primeiro, entre com o perfil de estudante escolhido");
					break;
				}
				salvaEstudante(estudante);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				estudante = recuperaEstudante();
				if (estudante.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo GrupoEscolar");
				break;
			}
		} while (opc1 != 9);
	}
	
	public static void main(String[] args) {
		GrupoEscolar ge = new GrupoEscolar();
		ge.menuGrupoEscolar();

	}
		


}
