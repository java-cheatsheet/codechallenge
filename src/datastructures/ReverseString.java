package datastructures;

public class ReverseString {
    public static void main(String[] args) {
        reverseStringUsingByte();
    }

    public static void reverseStringUsingByte() {
        String str = "anit is here";
        String reversedStr="";

        for(byte c:str.getBytes()){
            reversedStr = (char)c + reversedStr;
        }
        System.out.println("Original String is : " + str);
        System.out.println("Reversed String is : " + reversedStr);
    }
}
