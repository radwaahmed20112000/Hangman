
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Hangman implements HangmanInterface {
	//global
	public static String wordy;
	public static int a = 0;
	public static char[] str = {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'};
	public static String[] arr = new String[320];
	
	public static String[] readarray() throws Exception {
		Scanner sc = new Scanner(new File("file.txt"));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		arr = (String[]) lines.toArray(new String[320]);
		return arr;
	} 
		
	@Override 
	public void setDictionary(String[] words)  {
		try {
			words = readarray();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		String word;
		Random index = new Random();
		int i = index.nextInt(319);
		try {
			String[] h = new String[320];
			h= readarray();
			word = h[i];
			return word;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public String guess(Character c) throws Exception {
		if(a==0) {
		wordy = selectRandomSecretWord();} 
		int i,j = 0,k = 0;
		for(i = 0 ; i < wordy.length() ; i++) {
			if(c == wordy.charAt(i)) {
				str[i]=c;
			}
		}
		
        char[] ch = new char[wordy.length()]; 
        for ( i = 0 ; i < wordy.length(); i++) { 
            ch[i] = wordy.charAt(i); 
        } 
        
		for(i=0;i<wordy.length();i++) {
			if(ch[i]==str[i]) {
				k++;
			}
		}
		if(k==wordy.length()){
			return wordy;
		}
		else {
		String guess = String.copyValueOf(str);
		return guess; }
	}
	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		int count=0, k=0;
		if(max == null ) {
			max = 1;
		}
		Scanner input = new Scanner(System.in);
		
		while(k < max) {
			System.out.println("Enter your guess:");
			char x = input.next().charAt(0);
			String h;
			try {
				h = guess(x);
				a++;
				System.out.println(h);
				k++;
		        char[] ch = new char[h.length()]; 
		        for (int i = 0; i < h.length(); i++) { 
		            ch[i] = h.charAt(i); 
		        } 
		        for(int i=0;i<h.length();i++) {
		        	if(ch[i] == '-') {
		        		count++;
		        	}
		        }

				if (max == k && count !=0) {
					throw new Exception("Loser ! ");
				}
		        if(count ==0) {
		        	k=max;
		        	throw new Exception("Winner");
		        }
		        count =0;							
			} catch (Exception e) {
				e.printStackTrace();
			} 

		}

	}
	
}
