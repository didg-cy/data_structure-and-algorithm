package hash_table;

public class CheckStringAnagram {

    public boolean isAnagram(String a,String b){

        int[] count = new int[26];
        for(int i=0;i<a.length();i++){
            count[a.charAt(i)-'a']++;
        }

        for(int i=0;i<b.length();i++){
            count[b.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
}
