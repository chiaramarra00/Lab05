package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	List<String> anagrammi;
	AnagrammaDAO anagrammaDao = new AnagrammaDAO();

	public List<String> calcolaAnagramma(String input) {
		anagrammi = new LinkedList<String>();
		calcolaAnagramma_ricorsiva("", 0, input);
		return anagrammi;
	}

	private void calcolaAnagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length()==0) {
			anagrammi.add(new String(parziale));
		}
		else {
			for (int pos=0; pos<rimanenti.length(); pos++) {
				String new_parziale = parziale + rimanenti.charAt(pos);
				String new_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos+1);
				calcolaAnagramma_ricorsiva(new_parziale, livello+1, new_rimanenti);
			}
		}
	}

	public boolean isCorrect(String anagramma) {
		return anagrammaDao.isCorrect(anagramma);
	}

}
