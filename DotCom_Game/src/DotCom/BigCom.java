package DotCom;

import java.util.ArrayList;
import helper.GameHelper;

public class BigCom extends DotCom{
	private ArrayList<String> filiais = new ArrayList<String> ();
	int count = 0;
	
	int space = 0;
	GameHelper h = new GameHelper();
	
	public String hitMessage() {
		count++;
		String message;
		movePositions();
		if(count == 2){
			String s = filiais.get(0);
			filiais.remove(0);
			count = 0;
			message = "Voce Acertou a " + name + " e removeu a filial " + s;
		}else {
			message = "Voce Acertou a " + name;
		}
		return message;
	}

	public void setupDotCom() {
		filiais.add("Pichau");
		filiais.add("Kabum");
		h.setup();
		space = h.convertAlphatoNuber(locationCells.get(1)) - h.convertAlphatoNuber(locationCells.get(0));
	}
	
	
	
	public boolean movePositions() {
		String s;
		int random = (int)(Math.random() * 4);
		if(random == 3 & !h.gridOccupied(h.convertAlphatoNuber(locationCells.get(0)) - space)) {
			for(int i = 0; i < locationCells.size(); i++){
				s = locationCells.get(0);
				int temp = h.convertAlphatoNuber(s);
				temp -= space;
				locationCells.add(h.convertNumberToAlpha(temp));
				locationCells.remove(s);
			}
			System.out.println("A " + name + " moveu para frente");
			return true;
		}else if (random == 2 & !h.gridOccupied(h.convertAlphatoNuber(locationCells.get(locationCells.size()-1)) + space)) {
			for(int i = 0; i < locationCells.size(); i++){
				s = locationCells.get(0);
				int temp = h.convertAlphatoNuber(s);
				temp += space;
				locationCells.add(h.convertNumberToAlpha(temp));
				locationCells.remove(s);
			}
			System.out.println("A " + name + " moveu para tras");
			return true;
		}
		System.out.println("A " + name + " nao se moveu");
		return false;
		
	}
	
}
