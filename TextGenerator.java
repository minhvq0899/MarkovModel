
public class TextGenerator {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        String input = StdIn.readAll();

        MarkovModel minh = new MarkovModel(input, k); // create a MarkovModel

        String result = input.substring(0, k); // this is the first kgram
        StdOut.print(result);

        for (int i = 0; i < T - k; i++) { // go through the input text
            String tempKgram = result.substring(i); // get the kgram from string result
            char c = minh.random(tempKgram); // call random() on the kgram
            StdOut.print(c); // print out that character
            result = result.concat(Character.toString(c)); // concat that char c into our result
        }

        // to keep track of T and just so it looks better when run by terminal
        StdOut.println(" " + result.length());
    }
}

