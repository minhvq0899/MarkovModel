

public class MarkovModel {
    // intance variables
    public int k;
    public ST<String, int[]> freqency;


    // creates a Markov model of order k for the specified text
    public MarkovModel(String text, int k) {
        this.k = k;
        freqency = new ST<String, int[]>(); // create a ST from String to int[]

        // go through the text and get every kgram
        for (int i = 0; i < text.length(); i++) {
            String kgram;
            char c;
            int[] tempASCII = new int[128];

            // circular string
            if (i > text.length() - k) {
                String leftOver = text.substring(i);
                kgram = leftOver.concat(text.substring(0, k - leftOver.length()));
            }
            else if (i == text.length() - k) {
                kgram = text.substring(i);
            }
            else {
                kgram = text.substring(i, i + k);
            }

            // if ST table hasn't had the kgram yet
            if (!freqency.contains(kgram))
                freqency.put(kgram, tempASCII);

            // circular string
            if (i > text.length() - k)
                c = text.charAt(k - (text.length() - i));
            else if (i == text.length() - k)
                c = text.charAt(0);
            else
                c = text.charAt(i + k);

            // take the int[] of kgram out
            int[] f = freqency.get(kgram);
            // increment the frequency of character c
            f[(int) c]++;
            // put that int[] back into the ST
            freqency.put(kgram, f);
        }
    }


    // returns the order k of this Markov model
    public int order() {
        return k;
    }

    // returns a string representation of the Markov model (as described below)
    public String toString() {
        String result = ""; // this will be our result
        for (String tempKey : freqency.keys()) { // go through all the kgram
            int[] f = freqency.get(tempKey); // get the array out
            String tempResult = tempKey + ":" + " "; // update the result
            for (int i = 0; i < f.length; i++) { // go through all the characters in the array
                if (f[i] > 0) { // if any character has value more than 0
                    String tempK = Character.toString((char) i); //
                    tempResult = tempResult
                            .concat(tempK + " " + f[i] + " "); // print out the result
                }
            }
            result = result.concat(tempResult + "\n"); // prepare for the next kgram
        }
        return result;
    }

    // returns the number of times the specified kgram appears in the text
    public int freq(String kgram) {
        if (!freqency.contains(kgram)) // if kgram doesnot exist
            return 0;
        int result = 0; // start with 0
        int[] f = freqency.get(kgram); // get the array out
        for (int i = 0; i < f.length; i++) {
            result += f[i]; // add up all the values in the array
        }
        return result;
    }

    // returns the number of times the character c follows the specified
    // kgram in the text
    public int freq(String kgram, char c) {
        if (kgram.length() != k)
            throw new IllegalArgumentException();

        int cInInt = (int) c; // turn that char c into int
        int[] f = freqency.get(kgram);
        return f[cInInt]; // return the value of that index
    }

    // returns a random character that follows the specified kgram in the text,
    // chosen with weight proportional to the number of times that character
    // follows the specified kgram in the text
    public char random(String kgram) {
        if (kgram.length() != k)
            throw new IllegalArgumentException();

        if (!freqency.contains(kgram))
            throw new IllegalArgumentException();

        double n = 0.0;
        int[] f = freqency.get(kgram); // get the int[] out
        double random = Math.random(); // random double from 0-1
        for (int i = 0; i <= f.length; i++) {
            // increment n by the probability of character in i
            n = n + (double) f[i] / (double) freq(kgram);
            // once the n is bigger than random
            if (n > random)
                return (char) i;
        }
        return ' '; // this is just for syntax error, we will never return this case
    }

    public static void main(String[] args) {
        String text2 = "gagggagaggcgagaaa";
        MarkovModel model2 = new MarkovModel(text2, 5);
        StdOut.println(model2);
    }

}
