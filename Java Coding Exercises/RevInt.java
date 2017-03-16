//reverse int
class RevInt{
	public static void main(String args[]){
	int a = 786;
	String s = Integer.toBinaryString(a);
	System.out.println(s);
	int rev = 0;
	for(int i = s.length()-1;i>=0;i--){
		 rev = rev*10 + (s.charAt(i)-'0');
	}
	System.out.println(rev);
	}
}