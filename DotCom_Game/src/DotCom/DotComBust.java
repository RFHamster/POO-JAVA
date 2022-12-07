package DotCom;

import java.util.ArrayList;
import java.util.List;
import helper.GameHelper;

public class DotComBust {
  private GameHelper helper;
  private List<DotCom> dotcoms;
  private int count;

  private DotCom buildStartupCom(String name, int size) {
    DotCom dotcom = null;
    List<String> l;
    if(size == 3) {
    	dotcom = new StartupCom();
    	l = helper.placeDotCom(size);
    	dotcom.setName(name);
        dotcom.setLocationCells(l);
    	System.out.print(l);
    }else if(size == 4) {
    	dotcom = new MicroCom();
    	l = helper.placeDotCom(size);
    	dotcom.setName(name);
        dotcom.setLocationCells(l);
    	System.out.print(l);
    }else if (size == 5) {
    	dotcom = new JustAnotherDotCom();
    	((JustAnotherDotCom) dotcom).addContratantes();
    	dotcom.setName(name);
    	l = helper.placeDotCom(size);
    	dotcom.setLocationCells(l);
    	System.out.print(l);
    }else if (size == 6) {
    	dotcom = new BigCom();
    	dotcom.setName(name);
    	l = helper.placeDotCom(size);
    	dotcom.setLocationCells(l);
    	((BigCom) dotcom).setupDotCom();
    	System.out.print(l);
    }
    return dotcom;
  }
  
  public void setup() {
    helper = new GameHelper();
    dotcoms = new ArrayList<DotCom>();
    dotcoms.add(buildStartupCom("BigCom1", 6));  
    dotcoms.add(buildStartupCom("StartupCom1", 3));
    dotcoms.add(buildStartupCom("StartupCom2", 3));
    dotcoms.add(buildStartupCom("StartupCom3", 3));
    dotcoms.add(buildStartupCom("StartupCom4", 3));
    dotcoms.add(buildStartupCom("MicroCom1", 4));
    dotcoms.add(buildStartupCom("MicroCom2", 4));
    dotcoms.add(buildStartupCom("MicroCom3", 4));
    dotcoms.add(buildStartupCom("JustAnotherDotCom1", 5));
    dotcoms.add(buildStartupCom("JustAnotherDotCom2", 5));  
    
    count = 0;
  }

  // Inserir o método para iniciar o jogo, apresentar as regras, receber as jogadas do usuário, processar e informar o resultado de cada jogada, apresentar os resultados finais
  public void start() {
    System.out.println("Objetivos do jogo...");
    do {
      String jogada  = helper.getUserInput("Informe a jogada");
      System.out.println();
      count++;
      String result = "miss";
      DotCom hitted = null;
      for(DotCom dotcom : dotcoms) {
        result = dotcom.checkYourself(jogada);   
        if (result != "miss") {
          hitted = dotcom;
          if(result == "hit") {
        	  System.out.println(dotcom.hitMessage()); 
          }else {
        	  System.out.println(dotcom.killMessage());
          }
          
          break;
        }
        
      }
      if (result == "kill") {
        dotcoms.remove(hitted);
      }else if(result == "miss"){
    	  System.out.println(result); 
      }
    } while (!dotcoms.isEmpty());
    finishGame();
  }

// Inserir o método para apresentar os resultados do jogo  
  public void finishGame() {
    System.out.printf("Jogo terminado após %d jogadas.", count);
  }
  
  
}
