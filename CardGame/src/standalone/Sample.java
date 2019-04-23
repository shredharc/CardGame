package standalone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Sample {
	public static void main(String[] args) {
		ArrayList<String> faceValueList = new ArrayList<String>(
			    Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
		ArrayList<String> suitList = new ArrayList<String>(
			    Arrays.asList("Diamond", "Heart", "Club",  "Spade"));
		ArrayList<String> allCards = new ArrayList<>();
		Set<Integer> randomSet = getRandomSet();
		getRandomSuit(faceValueList, suitList, allCards, randomSet);
		
		//Story 2
		distrubuteUniqueCards(allCards);
	}

	private static void distrubuteUniqueCards(ArrayList<String> allCards) {
		Set<String> uniqueList = new HashSet<>();
		final int NUMBER_RANGE = 52;
		Random random = new Random();
        while(uniqueList.size() < 4) {
        		int nextInt = random.nextInt(NUMBER_RANGE);
        		uniqueList.add(allCards.get(nextInt));
        }
        for (String string : uniqueList) {
			System.out.println("Sample.distrubuteUniqueCards(): " + string);
		}
        
	}

	private static Set<Integer> getRandomSet() {	
		final int SET_SIZE_REQUIRED = 52;
		final int NUMBER_RANGE = 52;
		Random random = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>(SET_SIZE_REQUIRED);
	    	int nextInt;
	    	boolean add = true;
	    	int pNum = -1;
	    	int repeat = 0;
        while(set.size()< SET_SIZE_REQUIRED) {
        //	while (set.add(random.nextInt(NUMBER_RANGE)) != true);
	        	do {    
	        		nextInt = random.nextInt(NUMBER_RANGE);
	        		if (pNum != -1 && Math.abs(pNum - nextInt) % 4 == 0) {
	        			repeat ++;
	        			if (repeat == 4) {
	        				//don't add to set for continious 4th multiple 
	        				continue;
	        			}
	        		} else {
	        			repeat = 0;
	        		}
	        		pNum = nextInt;
				add = set.add(nextInt);
	        } while (add != true);
        }
        assert set.size() == SET_SIZE_REQUIRED;
        System.out.println("Random non repeating Set without continious 4th multiple: " + set);
        
        pNum = -1;
        for (Integer item : set) {
        		if (pNum != -1 && Math.abs(pNum - item) % 4 == 0) {
        			System.out.println("Sample.getRandomSet() - 4th multiple repeated pNum: " + pNum + ", currItem: " + item);
        		}
		}
        return set;
	}

	private static ArrayList<String> getRandomSuit(ArrayList<String> faceValueList, ArrayList<String> suitList, ArrayList<String> allCards, Set<Integer> randomSet) {
		System.out.println("START :: Sample.getRandom() - ramdon list");
		for (String faceValue : faceValueList) {
			for (String suit : suitList) {
				allCards.add(suit + " " + faceValue);
			}
		}
		System.out.println("Sample.getRandom() - Story 1 output list: ");
		for (Integer integer : randomSet) {
			System.out.println(allCards.get(integer));
		}
		System.out.println("END   :: Sample.getRandom() - ramdon list");
		return allCards;
	}
}
