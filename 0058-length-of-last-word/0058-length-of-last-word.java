class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim (); // trim function
        
        int lastSpace = s.lastIndexOf(' '); // lastIndexOf 

    return s.length() - lastSpace - 1; 
    }
}

//build in string method 
