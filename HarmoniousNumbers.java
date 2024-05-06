import java.util.HashSet;
import java.util.ArrayList;

public class HarmoniousNumbers {
    // this hashset is much quicker than rechecking over all the numbers iterated through
    public static HashSet<Integer> usedNums = new HashSet<>();
    private static int max = 0;
    public static void main(String[] args){
        if(args.length > 0){
            // if the user passes a number through, use that as the max
            try{
                max = Integer.parseInt(args[0].trim());
            // if the user didn't enter an int, default to 2 million
            }catch(NumberFormatException e){
                System.out.println("No Number Passed through, defaulting to 2 million");
                max = 2000000;
            }
        // if there is no argument default to 2 million.
        }else{
            max = 2000000;
        }
        // not necessary but nice to know that the program is working
        // System.out.println("Working...");
        ArrayList<int[]> pairs = findHarmoniousPairs();
        for(int i = 0; i< pairs.size(); i++){
            System.out.println(pairs.get(i)[0] + " " + pairs.get(i)[1]);
        }
    }
    public static ArrayList<int[]> findHarmoniousPairs(){
        ArrayList<int[]> pairs = new ArrayList<>();
        // skip 1 because we don't want it
        for(int i = 2; i<= max; i++){
            int sum = sumOfDivisors(i);
            // check that the sum of the sum of divisors of i is equal to i
            // (the other number in the pair is also equal to the sum of the divisors of the other number)
            if(sumOfDivisors(sum) == i){
                // check that the numbers haven't already been used - we don't want duplicates
                // also make sure that the sum isn't larger than the specificed max
                if(!usedNums.contains(i) && !usedNums.contains(sum) && sum <= max){
                    // add both numbers to used list so we don't use them again
                    usedNums.add(i);
                    usedNums.add(sum);
                    // can't print in real time because we have to put the smaller number in the pair first
                    // System.out.println(i + " " + sum);
                    if(i < sum){
                        pairs.add(new int[]{i, sum});
                    }else{
                        pairs.add(new int[]{sum, i});
                    }
                }
            }
        }
        // sort the pairs by the first number in the pair (smallest to largest)
        pairs.sort((a, b) -> Integer.compare(a[0], b[0]));
        return pairs;
    }
    // sum of divisors of number excluding 1 so that they are "harmonious"
    public static int sumOfDivisors(int n){
        int sum = 0;
        // skip 1 because we don't want it in the sum
        // run to the sqrt of n because numbers larger than that's divisors won't be equal to i (in find harmoniousNumbers)
        for(int i = 2; i<= Math.sqrt(n); i++){
            // check that the number is a divisor
            if(n%i == 0){
                sum += i;
                if(i != n/i){
                    sum += n/i;
                }
            }
        }
        return sum;
    }
}