public class HarmoniousNumbers {
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
        findHarmoniousPairs();
    }
    public static void findHarmoniousPairs(){
        // skip 1 because we don't want it
        for(int i = 2; i<= max; i++){
            int sum = sumOfDivisors(i);
            // check that the sum of the sum of divisors of i is equal to i
            // (the other number in the pair is also equal to the sum of the divisors of the other number)
            if(sumOfDivisors(sum) == i){
                // making sure that i < sum stops duplicates and also makes output start with smaller number
                if(i < sum){
                        System.out.println(i + " " + sum);                    
                }
            }
        }
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