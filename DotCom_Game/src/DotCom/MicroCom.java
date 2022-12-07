package DotCom;

public class MicroCom extends DotCom{
	private String contratante = "Magazine Luiza";
	private int count = 4;
	
	public String hitMessage() {
		count--;
		return "Nao me acerte novamente " + count + " vezes, para eu nao perder meu contrato com a " + contratante;
	}
	
	
}
