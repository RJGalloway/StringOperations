package ryan_galloway.company;

import java.util.ArrayList;;
import java.util.Random;

public class StringOperations {
    //Function takes in a string and reverses its contents.
    public String reverseString(String input)
    {
        char[] reversedInput = new char[input.length()];
        //Converts string to char array
        char[] myCharArray = input.toCharArray();
        int initial = myCharArray.length - 1;
        //Loop that uses two index variables for the new char array that will take the reversed string and for
        //the initial arrays last index. It then increments and decrements them respectively to copy the elements of
        //the initial array to the new array in reverse order.
        for (int reversedIndex = 0; reversedIndex <= (myCharArray.length - 1); reversedIndex++, initial--) {
            reversedInput[reversedIndex] = myCharArray[initial];
        }
        String output = new String(reversedInput);
        return output;
    }
    public String concatenateStringOdd(String input)
    {
        String output;
        int count = 0;
        char[] myCharArray = input.toCharArray();
        for(int i = 0; i <myCharArray.length; i++)
        {
            if(i % 2 !=0)
            {
                count++;
            }
        }
        char[] tempArray = new char[count];
        for(int i = 0; i <= myCharArray.length - 1; i++)
        {
            if( i % 2 != 0)
            {
               tempArray[i/2] = myCharArray[i];
            }
        }
        String evenIndices = new String(tempArray);
        output = reverseString(evenIndices);
        return output;
    }
    public String concatenateStringEven(String input)
    {
        String output;
        int count = 0;
        char[] myCharArray = input.toCharArray();
        for(int i = 0; i <myCharArray.length; i++)
        {
            if(i % 2 ==0)
            {
                count++;
            }
        }
        char[] tempArray = new char[count];
        for(int i = 0; i <= myCharArray.length - 1; i++)
        {
            if( i % 2 == 0)
            {
                tempArray[i/2] = myCharArray[i];
            }
        }
        String evenIndices = new String(tempArray);
        output = reverseString(evenIndices);
        return output;
    }
    public String randomStringCreation(String input)
    {
        int num;
        ArrayList<Character> al = new ArrayList<>();
        ArrayList<Character> tempAl = new ArrayList<>();
        for(int i = 0; i < input.length(); i++)
        {
            al.add(input.charAt(i));
        }
        Random randNum = new Random();
        while(al.size() > 0)
        {
            num = randNum.nextInt(al.size());
            tempAl.add(al.get(num));
            al.remove(num);
        }
        String str = tempAl.toString().replaceAll(",", "" );
        char[] chars = str.substring(1, str.length()-1).replaceAll(" ", "").toCharArray();
        String randomString = new String(chars);
        return randomString;
    }

}
