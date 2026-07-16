class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        num1=new StringBuilder(num1).reverse().toString();
        num2=new StringBuilder(num2).reverse().toString();
        int n=num1.length();
        int m=num2.length();
        int [] result=new int[n+m];
        for(int i=0;i<n;i++){
            int digit1=num1.charAt(i)-'0';
            for(int j=0;j<m;j++){
                int digit2=num2.charAt(j)-'0';
                int product=digit1*digit2;
                result[i+j] +=product;
                result[i + j + 1] += result[i + j] / 10;
                result[i + j] %= 10;
            }
        }
        int index=result.length-1;
        while(index>0 &&result[index]==0){
            index--;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            ans.append(result[i]);
        }

        return ans.reverse().toString();
    }
}