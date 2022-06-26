
public class Functions {
	public static boolean  isPrime(int n){
		boolean ans = true;
		double sqn = Math.sqrt(n);
		for(int i=2; ans && i<=sqn; i++){//<=
			if (n%i == 0) ans = false;
		}
		return ans;
	}
	public static int numDividers(int n){
		int ans = 0;
		double sqn = Math.sqrt(n);
		for(int i=2; i<=sqn; i++){//<=
			if (n%i == 0) ans = ans + 2;
		}
		if((int)sqn * (int)sqn == n) ans--;
		return ans;
	}
	public static String reverse(String s){
		String t = "";
		for (int i=0; i<s.length(); i++){
			t = s.charAt(i) + t;
		}
		return t;
	}
	public static void infinity(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//while(true);
	}
	public static int[] longestMonotony(int[]a){
		int count = 1, maxCount = 1, end = 0;
		for (int i = 0; i < a.length-1; i++) {
			if(a[i] < a[i+1]) count++;
			else{
				if (count > maxCount){
					end = i+1;
					maxCount = count;
					//count = 1;
				}
				count = 1;
			}
		}
		if (count > maxCount){
			end = a.length;
			maxCount = count;
		}
		int [] ans = new int[maxCount];
		int start = end - maxCount;
		for(int i=0; i<maxCount; i++){
			ans[i] = a[i+start];
		}
		return ans;
	}
}
