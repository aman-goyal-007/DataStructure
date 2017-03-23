
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Set;

public class PatternExists {

public static void main(String...args){
	System.out.println(doesStringHasPattern("abaaba"));

}
	
	static boolean doesStringHasPattern(String givenString) {
		boolean doesStringHasPattern=false;
        int length =givenString.length();
        ArrayList<Integer> poss = new ArrayList<Integer>();
        for(int i=1;i<=length/2;i++){
            if(length%i ==0)
                poss.add(i);
        }
        HashMap<Integer,String> patterns = new HashMap<Integer,String>();
        HashMap<Integer,Boolean> patternMatch = new HashMap<Integer,Boolean>();
        for(int i:poss){
            patterns.put(i,null);
        }
        int startIndex=0;
        for(int i=0;i<givenString.length();i++){
            if(patterns.containsValue(null)) 
                    patterns.put(i+1,givenString.substring(0,i+1));
                    
                
            }
        
        Set<Integer> i=patterns.keySet();
        boolean pattMatch=false;
        int j=0;
        int patternindex=0;
        int stringLength=givenString.length();
        for(Integer processingKey:i){
            
            int key =processingKey;
            String patt=patterns.get(key);
            BitSet bitSet = new BitSet(givenString.length()/key);            
            int start=0;
            int endIndex=0;
			int bitSetIndex=0;
            while(true){
            	endIndex=start+key;
//					System.out.println("Patt - "+patt+","+start+"."+endIndex+","+givenString.substring(start,endIndex)+","+(endIndex<=(stringLength))+","+patt.equals(givenString.substring(start,endIndex)));
            	if(endIndex<=(stringLength)){
//					System.out.println("Patt inside- "+patt+","+start+"."+endIndex+","+givenString.substring(start,endIndex));
            		if(patt.equals(givenString.substring(start,endIndex))){
//						System.out.println(bitSetIndex);
            			bitSet.set(bitSetIndex++);
					}
            		else 
            			break;
            	}else
					break;
				start=start+key;
            }
			int check=stringLength/key;
//			System.out.println(key+"--"+bitSet.cardinality()+"--"+check);
            if(bitSet.cardinality()==check){
              patternindex=key;
                break;
            }
        }
        if(patternindex != 0)
            doesStringHasPattern=true;
        else doesStringHasPattern=false;
            
        
        
        
		return doesStringHasPattern;
    }
}
