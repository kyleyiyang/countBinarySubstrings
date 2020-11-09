class Solution {
    public int countBinarySubstrings(String s) {
        int n=0;
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i)!=s.charAt(i+1)) {
                if (i==0) n++;
                else n+=rec(s,i,i+1);
            }
        }
        return n;
    }
    public int rec(String s,int i,int j) {
        int count=1;
        while (i>0 && j<s.length()-1 && s.charAt(i)==s.charAt(i-1) && s.charAt(j)==s.charAt(j+1)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}

// same time complexity although should be faster
class Solution {
    public int countBinarySubstrings(String s) {
        int[] n=new int[2];
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i)!=s.charAt(i+1)) {
                if (i==0) n[0]++;
                else {
                    int[] temp=rec(s,i,i+1);
                    n[0]+=temp[0];
                    i=temp[1]-1;
                }
            }
        }
        return n[0];
    }
    public int[] rec(String s,int i,int j) {
        int[] out=new int[2];
        int count=1;
        while (i>0 && j<s.length()-1 && s.charAt(i)==s.charAt(i-1) && s.charAt(j)==s.charAt(j+1)) {
            count++;
            i--;
            j++;
        }
        out[0]=count;
        out[1]=j;
        return out;
    }
}
