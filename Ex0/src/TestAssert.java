
// enable assertion: Run->Run Configurations -> Arguments -> VM arguments: -ea (enable assertions)
public class TestAssert {

	static int factorial1(int n){
		assert(n >= 0) : "error: n<0!";
		assert(n <= 10) : "error: n>10";
		if (n < 2) {
			return 1;
		}
		return factorial1(n - 1) * n;
	}

	static int factorial2(int n){
		int result = 1;
		for (int i = 2; i <= n; ++i) {
			result = result*i;
		}
		assert(result > 0) : "n is too big, result<0";

		return result;
	}	
	public static void main(String[] args) {

		System.out.println(factorial1(10));
		System.out.println(factorial2(17));
		System.out.println("exit main");
	}

}
