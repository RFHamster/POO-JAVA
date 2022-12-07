package helper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

  private static final String alphabet = "abcdefghij";
  private int gridLength = 10;
  private int gridSize = 100;
  private int [] grid = new int[gridSize];
  private int comCount = 0;
  private ArrayList<String> letras = new ArrayList<String> ();

  public void setup() {
		letras.add("a");
		letras.add("b");
		letras.add("c");
		letras.add("d");
		letras.add("e");
		letras.add("f");
		letras.add("g");
		letras.add("h");
		letras.add("i");
		letras.add("j");
  }

  public String getUserInput(String prompt) {
	 String inputLine = null;
	 System.out.print(prompt + "  ");
     try {
       BufferedReader is = new BufferedReader(
	 new InputStreamReader(System.in));
       inputLine = is.readLine();
       if (inputLine.length() == 0 )  return null; 
     } catch (IOException e) {
       System.out.println("IOException: " + e);
     }
     return inputLine.toLowerCase();
  }

  public boolean gridOccupied(int x) {
	  if(x < 0 & grid[x] >= 1) {
		  return true;
	  }else {
		  return false;
	  }
	  
  }
  
  public String convertNumberToAlpha(int number) {
	  int row = 0;
	  int column = 0;
	  row = (int) (number / gridLength);        
      column = number % gridLength;            
      String temp = String.valueOf(alphabet.charAt(column));   
      return temp.concat(Integer.toString(row));
  }
  
	public int convertAlphatoNuber(String s) {
		String primeiro = ""+s.charAt(1);
		String segundo = ""+s.charAt(0);
		int seg;
		seg = letras.indexOf(segundo);
		int pri = Integer.parseInt(primeiro) * 10;
		return seg + pri;
	}
  
  public ArrayList<String> placeDotCom(int comSize) {
	  ArrayList<String> alphaCells = new ArrayList<String>();                                 
	  int [] coords = new int[comSize];                  
	  int attempts = 0;                                 
	  boolean success = false;                          
	  int location = 0;                               
	    
	  //se a com for impar ela fica na vertical, se for par na horizontal
	  comCount++;                                       
	  int incr = 1;                                     
	  if ((comCount % 2) == 1) {                   
	    incr = gridLength;                              
	  }
	    
	  //tentar as posicoes ate arumar uma posicao sem problemas para a dotcom
	  while (!success & attempts++ < 100 ) {          
	  location = (int) (Math.random() * gridSize);
		int x = 0;                                      
	        success = true;                  
	        while (success && x < comSize) {       
	          if (grid[location] == 0) {                  
	             coords[x++] = location;               
	             location += incr;                    
	             if (location >= gridSize){ //passou da grid            
	               success = false;                
	             }
	             if (x>0 & (location % gridLength == 0)) { //passou da grid
	               success = false;                       
	             }
	          } else {//grid ocupada
	              success = false;                      
	          }
	        }
	    }                                            
	
	    //converter de vetor para alpha (de "12" para "a2")
	    int x = 0;
	    while (x < comSize) {
	      grid[coords[x]] = 1;
	      alphaCells.add(convertNumberToAlpha(coords[x]));
	      x++; 
	    }
	    
	    return alphaCells;
	   }
	}