//First unique element

class FirstUnique{
	
	public static void main(String args[]){
		String s = "ababceddc";
		char c = findFirstUnique(s);
		System.out.println(c);
	}

	public static char findFirstUnique(String s){
		
		int[] arr = new int[26];

		for(int i=0; i<s.length();i++)
			arr[s.charAt(i) - 'a']+=1;

		for(int i=0;i<s.length;i++)
			if(arr[s.charAt(i)]==1) return i;

		return ;
		
	}
}