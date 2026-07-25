class Solution {
    public int maxProduct(int n) {
        int mul=1;
        int num1=0;
        int num2=0;
        while(n>0){
            int digit=n%10;
            if(digit>=num1){
                num2=num1;
                num1=digit;
            }
            else if(digit>num2){
                num2=digit;
            }
            
            n=n/10;
        }
        mul=num1*num2;
        return mul;
    }
}