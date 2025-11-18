package hash_table;

public class RansomNoteChecker {


    public boolean randomNoteChecker(String note, String magzine){
        if(note.length() > magzine.length()){
            return false;
        }

        int[] checker =  new int[26];

        for(int i = 0; i<magzine.length(); i++) {
            checker[magzine.charAt(i) - 'a']++;
        }
        for(int i = 0; i<note.length(); i++) {
            int index = note.charAt(i) - 'a';
            checker[index]--;
            if(checker[index] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        RansomNoteChecker e = new RansomNoteChecker();
        boolean checkResults = e.randomNoteChecker("aa", "aab");
        System.out.println(checkResults);
    }
}
