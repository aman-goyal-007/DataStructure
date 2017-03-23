
public class PhonenumberToString {
	public static void main(String...args){
		printCombination("2665", 4, 0, new String());
	}
	
	static String charAt(int number,int position){
		String[][] check={{"0","0","0"},
						  {"1","1","1"},
						  {"A","B","C"},
						  {"D","E","F"},
						  {"G","H","I"},
						  {"J","K","L"},
						  {"M","N","O"},
						  {"P","Q","R"},
						  {"T","U","V"},
						  {"W","X","Y"}
						  };
		return check[number][position];
	}
	
	static void printCombination(String phoneNumber,int length,int index,String comb){
		if(index<(length-1)){
			int number=Integer.valueOf(phoneNumber.charAt(index)+"");
			for(int i=0;i<3;i++){
				comb+=charAt(number, i);
				printCombination(phoneNumber,length,++index,comb);
				comb = comb.substring(0,index-1);
				index--;
			}
		}
		else{
			int number=Integer.valueOf(phoneNumber.charAt(length-1)+"");
			String newString=null;
			for(int i=0;i<3;i++){
				newString=comb;
				newString+=charAt(number, i);
				System.out.println(newString);
			}
		}
	}

}
