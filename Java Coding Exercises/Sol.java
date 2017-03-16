class Sol{
	public static void main(String args[]){
	long sum = 0;
	String str = "123";
	for (int i = 0;i<str.length();i++){
	sum = sum*10 +str.charAt(i) ;
	System.out.println(sum);
	}
	}
}