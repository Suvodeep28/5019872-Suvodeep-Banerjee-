/*
 * Exercise 7: Financial Forecasting
Scenario: 
You are developing a financial forecasting tool that predicts future values based on past data.
Steps:
1.	Understand Recursive Algorithms:
o	Explain the concept of recursion and how it can simplify certain problems.
2.	Setup:
o	Create a method to calculate the future value using a recursive approach.
3.	Implementation:
o	Implement a recursive algorithm to predict future values based on past growth rates.
4.	Analysis:
o	Discuss the time complexity of your recursive algorithm.
o	Explain how to optimize the recursive solution to avoid excessive computation.

 */




 /*
  * 1. Understand Recursive Algorithms:
Recursion: A function calls itself to solve smaller instances of the problem, often simplifying the solution.
  */

  class FinancialForecasting {
    public double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        FinancialForecasting ff = new FinancialForecasting();
        System.out.println(ff.predictFutureValue(1000, 0.05, 10));
    }
}




  /*4. Analysis:
Time Complexity: O(n) for n years.
Optimization:
Use memoization to store and reuse previously calculated values, reducing redundant calculations.
Convert to an iterative solution to avoid stack overflow issues for large n.
 */