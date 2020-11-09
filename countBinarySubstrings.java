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
