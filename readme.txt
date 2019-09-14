/* *****************************************************************************
 *  Name: Minh Vu
 *  NetID:
 *  Precept:
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 **************************************************************************** */

Which partner is submitting the program files?

Programming Assignment 7: Markov Model

Hours to complete assignment (optional): more than 10

/**********************************************************************
 * Describe the type parameters of your symbol table (i.e., what is   *
 * the key type and what is the value type). How did you use the      *
 * symbol table to implement the random() method.                     *
 **********************************************************************/
Key is String (kgram), value is int[]. 
For my random method, I will go into the symbol table, find the kgram and pull its int[] out. Each character in this int[] will has a frequency and from there we can find its probability of it  apprearing after our kgram by dividing its frequency to the total number of time our kgram apprears in the input text. Generate a random double n from 0-1. Use a for loop to add up the probability of each character and check to see if that sum is bigger than n. Once it is bigger, return that character.  


/**********************************************************************
 * The main() method we provide in the checklist does not test your   *
 * random() method. Describe how you tested it.                       *
 **********************************************************************/
I tested it with my TextGenerator. I try to create an output text using random to generate each letter one by one, based on the initial kgram. 


/**********************************************************************
 * Paste two of your favorite, not too long, output fragments here.   *
 * In addition to the pseudo-random text, indicate the order of your  *
 * model and what text file you used.                                 *
 **********************************************************************/

 /c/projects/MarkovModel> java TextGenerator 2 100 < input17.txt
gagagagaggaggggcgaggggaaaggcgagggaggaaggaagggcgaggcgaggggcgaggggcgaaagagagaggggcgagggaggcgaggaggagag 100

/c/projects/MarkovModel> java TextGenerator 7 1000 < opening-exercsises.txt
Good afternoon and welcome you are right. But even if you who are pathbreaking research university that is valuable; all you have here will create during your tim
e on this particular suggestion.

There is magic in this campus. Inside this chapel but the broadest and more meaning in the pa
th to class, or in later chapter, or even the alumni chapter, but of an entirely new book. An
d what a beginning of a story, can make it easy to feel  without really thinking that Princet
on  you have seen this chapel looks much more like the best of our favorite times of them to
lunch.

Taking that this sort of unreflect on the intimacy and that you will take advantage of the year. It is a truly global institution. As scholars who are returning t
o teach you here has something to teach you  and, to invoke the best friends whom they knew personal enough and there is some life that this Universitys GREAT CLA
SS OF 2018! I also offer insight and commitment that you are feeling, you are feeling, you are f 1000
 

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no? Yes. Professors



/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?

No. 


/**********************************************************************
 *  List any other comments here.                                     *
 **********************************************************************/

