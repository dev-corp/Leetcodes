class Solution
{
	public String multiply(String num1, String num2) 
    {
		if ("0".equals(num1) || "0".equals(num2))
			return "0";

		int[] ans = new int[num1.length() + num2.length() - 1];

		for (int i = 0; i < num1.length(); i++) 
        {
			for (int j = 0; j < num2.length(); j++) 
            {
				ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}

		for (int i = ans.length - 1; i > 0; i--) 
        {
			ans[i - 1] += ans[i] / 10;
			ans[i] %= 10;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : ans) 
        {
			sb.append(i);
		}
		return sb.toString();
	}
}

// genius thought process
// This logic has been taken straight from vedic maths
// ex. 12*90 will be done like this

// (0*2)=0
// (1*0)+(2*9)+(1*9)=18(carry=1)=>8
// 1*9(+carry)=10

// i.e 1080