import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How many generations of children will you have?: ");
    int generationAmount = input.nextInt();
    System.out.println("How many nucleotides do you have?: ");
    int nucleotideAmount = input.nextInt();
    
    // creating random sequence
    String sequence = "";
    int num;
    for (int a = 0; a < nucleotideAmount; a++) {
      num = (int)(Math.random() * 4) + 1;
      
      switch (num) {
        case 1: sequence += "a"; break;
        case 2: sequence += "c"; break;
        case 3: sequence += "g"; break;
        case 4: sequence += "t"; break;
      }
    }
    System.out.println(sequence + " are your starting genes");
    
    // Going thru each letter and randomly deciding if it should mutate. doing this for x generations
    String newSequence = "";
    for (int h = 0; h < generationAmount; h++) {
      newSequence = "";
      for (int i = 0; i < sequence.length(); i++) {
        String newMutated = "";
        if (Math.random() < 0.05) {
          num = ((int)(Math.random()*4) +1);
          switch (num) {
            case 1: newMutated = "a"; break;
            case 2: newMutated = "c"; break;
            case 3: newMutated = "g"; break;
            case 4: newMutated = "t"; break; }
          if (newMutated.equals(sequence.substring(i, i+1))) { 
            num = num % 4 + 1;
            switch (num) {
              case 1: newMutated = "a"; break;
              case 2: newMutated = "t"; break;
              case 3: newMutated = "c"; break;
              case 4: newMutated = "g"; break; }
          }
          newSequence += newMutated.toUpperCase();
        }
        else newSequence += sequence.substring(i, i+1);
      }
      sequence = newSequence;
    }

    // System.out.println(newSequence);
  

    if (newSequence.indexOf("aaaa") != -1) System.out.println(newSequence + " are you genes after " + generationAmount + " later.\nYou have cancer");
    else System.out.println(newSequence + " are you genes after " + generationAmount + " later.\nYour genes look fine");
    
    /*switch (newSequence.toLowerCase()) {
      case "[SPECIAL SEQUENCE]": System.out.println("Cool, you have [SPECIAL TRAIT]"); break;
      case "[SPECIAL SEQUENCE1]": System.out.println("Cool, you have [SPECIAL TRAIT1]"); break;
      case "[SPECIAL SEQUENCE2]": System.out.println("Cool, you have [SPECIAL TRAIT2]"); break;
      case "[SPECIAL SEQUENCE3]": System.out.println("Cool, you have [SPECIAL TRAIT3]"); break;
      case "[SPECIAL SEQUENCE4]": System.out.println("Cool, you have [SPECIAL TRAIT4]"); break;
      case "[SPECIAL SEQUENCE5]": System.out.println("Cool, you have [SPECIAL TRAIT5]"); break;
      case "[SPECIAL SEQUENCE6]": System.out.println("Cool, you have [SPECIAL TRAIT6]"); break;
      case "[SPECIAL SEQUENCE7]": System.out.println("Cool, you have [SPECIAL TRAIT7]"); break;
      case "[SPECIAL SEQUENCE8]": System.out.println("Cool, you have [SPECIAL TRAIT8]"); break;
      case "[SPECIAL SEQUENCE9]": System.out.println("Cool, you have [SPECIAL TRAIT9]"); break;
    }*/



/////////////////////////////////////////////////////////////////////////////////////////////////

    
    /*Testing amount of times it would take to get a mutation with 0.15 (about 6.6)
    int mutateAvg = 0;
    for (int i = 0; i < 100000; i++) {
      boolean doMutate = false;
      int x = 0;
      while (!doMutate) {
        if (Math.random() < 0.15) doMutate = true;
        x++;
        // System.out.println(x);
      }
      mutateAvg += x;
    }
    System.out.println((double)mutateAvg/100000);*/


}
}