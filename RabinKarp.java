
public class RabinKarp {

	public static void main(String...args){
		checkIndexForPattern("AABAACAADAABAABA","AABA");
	}
	
	public static void checkIndexForPattern(String str,String pat){
		int length=pat.length();
		int prime=101;
		long hashPat=calculateHash(pat, 0, length, prime, 0);
		long hashStr=0;
		for(int i=0;i<=(str.length()-length);i++){
			hashStr=calculateHash(str, i, length, prime, hashStr);
			if(hashPat==hashStr){
					if(pat.equals(str.substring(i,i+length)))System.out.println(i);
			}
		}
	}
	
	public static long calculateHash(String str,int start,int length,int prime,long hash){
		if(start==0){
			for(int i=start;i<(start+length);i++){
				hash+=(str.charAt(i)*Math.pow(prime, i));
			}
		}else{
			hash-=str.charAt(start-1);
			hash/=prime;
			hash+=str.charAt(start+length-1)*Math.pow(prime, length-1);
		}		
		return hash;
	}
}
