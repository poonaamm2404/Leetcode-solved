class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] c=new int[n];
        boolean[] seenA=new boolean[n+1];
        boolean[] seenB=new boolean[n+1];
        for(int i=0;i<n;i++){
            seenA[A[i]]=true;
            seenB[B[i]]=true;
            int count=0;
            for(int j=1;j<=n;j++){
                if(seenA[j]==true && seenB[j]==true){
                    count++;
                }
            }
            c[i]=count;
        }
        return c;
    }
}