public static int returnMinDist(String[] words, String w1, String w2){
	
	int idx1 = Integer.MAX_VALUE,idx2 = Integer.MAX_VALUE;
	int minDist = Integer.MAX_VALUE;
	int newDist;

	for(int i=0;i<words.length;i++)
	{
		if(words[i] == w1) idx1 = i;
		else if (words[i] == w2) idx2 = i;
		if(idx1 != Integer.MAX_VALUE && idx2 != Integer.MAX_VALUE)
		{
			newDist = Math.abs(idx1-idx2);
			if (newDist<minDist) minDist = newDist;
		}
	
	}
	return minDist;
}