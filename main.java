package ryan_galloway.company;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        StringOperations concatenate =  new StringOperations();
        String str1 = "Beautiful";
        String str2 = "Strong";
        String str3 = "Smart";
        String str4 = "Caring";

        try (BufferedWriter outFile = new BufferedWriter(new FileWriter("stringsToReverse.txt", false)))
        {
            outFile.write(str1);
            outFile.newLine();
            outFile.write(str2);
            outFile.newLine();
            outFile.write(str3);
            outFile.newLine();
            outFile.write(str4);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        String line;
        BufferedReader inFile = null;

        try
        {
            inFile = new BufferedReader(new FileReader("stringsToReverse.txt"));
            line = inFile.readLine();
            StringOperations SO1 = new StringOperations();
            StringOperations SO2 = new StringOperations();
            StringOperations SO3 = new StringOperations();
            StringOperations SO4 = new StringOperations();
            while (line != null)
            {
                String myReversedString = SO1.reverseString(line);
                String concatEvenIndices = SO2.concatenateStringEven(line);
                String concatOddIndices = SO3.concatenateStringOdd(line);
                String concatFinal = concatEvenIndices + concatOddIndices;
                String randString = SO4.randomStringCreation(line);
                try(BufferedWriter reverseFile = new BufferedWriter(new FileWriter("reversedStrings.txt", true)))
                {
                    reverseFile.write(myReversedString);
                    reverseFile.newLine();
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
                line = inFile.readLine();
                try(BufferedWriter concatString = new BufferedWriter(new FileWriter("concatStrings.txt", true)))
                {
                    concatString.write(concatFinal);
                    concatString.newLine();
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
                try(BufferedWriter file = new BufferedWriter(new FileWriter("randomStrings.txt", true)))
                {
                    file.write(randString);
                    file.newLine();
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (inFile != null)
                    inFile.close();
            }
            catch ( IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
