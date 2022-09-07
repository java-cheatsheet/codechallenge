package hackerrank;

/**
 * Problem: TODO

 Arrange engineers in all possible team configurations.

 We are trying to find out how we can best organize our
 engineering teams. For this, we want to make sure we
 consider all options, and thus we want to create a list of
 all possible teams.

 You will assume that we have at most 26 engineers, and
 that each engineer is given a unique lowercase character
 as a personal identifier, from a to z.

 You will read the input on STDIN, which will be a single line
 that contains a string formed of the identifiers of engineers
 we want to create teams with. You will write to STDOUT the
 list of all the possible teams you can create with those
 engineers.

 You will notice in the examples below that the output is
 sorted in ascending lexicographical order. Shorter strings
 come before longer strings, and a < b < ... < z.

 The ouput strings shuld also be ordered lexicographically to ensure that the teams are unique, i.e. 'cba' should be
 printed as 'abc'.

 Example1:
 Only two engineers. In that case there are only two
 possibilities: ether we have two teams of oine engineer
 each, or we have a single team with two engineer.
 Sample input: ab
 Sample output:
 a
 b
 ab

 Example 2:
 THis time with three engineers. Therefore we can have
 teams of one, two or three engineers.
 Sample input: abc
 Sample output:
 a
 b
 c
 ab
 bc
 ac
 abc

 */
public class ArrangeEngineers {
}
