# Harmonious Numbers
## Running Implementation
The code defaults to running up to 2 million, but you can also input the number you want to iterate to using args (such as 'java HarmoniousNumbers 2000000')
## Implementation
Using a hashset as contains() has a [better time complexity](https://www.baeldung.com/java-hashset-arraylist-contains-performance) than that of a list

The main method of HarmoniousNumbers checks if any arguments are passed to the class in terminal, if it is unable to parse the argument to an int it simply defaults to 2 million and runs.

Both harmoniousPairs and sumOfDivisors start with an int value of 2 in order to skip over 1 so it isn't added to the sum (Aunt Maude would be unhappy if we included it).

Furthermore, there is a hashset of previously used numbers. we're able to assume that if the number has been used already we can just skip over it because the sum of one numbers divisors is going to equal a pair that we have already discovered if it is in the hashset. This means that it is looking while running, so we're keeping iteration to a minimum.

The main algorithm - harmoniousPairs pretty much has a time complexity of O(max*sqrt(n))because harmoniousPairs calls sumOfDivisors twice for each number and iterates to max (and sumOfDivisors runs to the sqrt of the current number (n)).

The time complexity of sorting using comparison of an array or list is usually [O(n log n)](https://www.baeldung.com/arrays-sortobject-vs-sortint)

We also need to iterate through the array once more to print, which is O(num of pairs).
## Etude PDF Introduction
Amicable numbers are pairs of numbers such that the sum of the proper divisors of
each one is equal to the other. The smallest such pair of numbers is 220 and 284.
<br>Your great aunt Maude has long believed that it is a fundamental error to consider 1 to
be a proper divisor of any number1, so she calls a pair of numbers harmonious if the sum
of the proper divisors in her sense of either one is equal to the other. She has tasked
you with providing a catalogue of all pairs of harmonious numbers where the smaller
one is less than 2,000,000.
<br>Note that the difference between harmonious and amicable pairs is just in how we com-
pute the “sum of the proper divisors”. For harmonious pairs we exclude 1 from the
sum of proper divisors.
## Task
Write a program that computes all pairs of harmonious numbers and outputs them, one
pair to a line, separated by a space, to stdout. 
<br>The smaller number of each pair should
be listed first, and there should be no duplicates.
<br>The pairs must be written in increasing order of the smaller number. That is, looking
down the output, the first column increases.