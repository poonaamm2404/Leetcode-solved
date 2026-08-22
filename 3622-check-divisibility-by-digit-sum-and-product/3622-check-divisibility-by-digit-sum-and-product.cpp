class Solution {
public:
    bool checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int dup=n;
        while(dup>0){
            int digit=dup%10;
            prod*=digit;
            sum+=digit;            
            dup=dup/10;
        }
        int res=sum+prod;
        if(n % res == 0){
            return true;
        }
        return false;
    }
};