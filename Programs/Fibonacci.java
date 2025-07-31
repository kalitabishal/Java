public class Fibonacci {
    private static long[] fibonacciCache;
    public static void main(String[] args ){
int n = 50;
fibonacciCache = new long [n + 1];

System.out.println(fibonacci(n));
    }
    private static long fibonacci(int n){
        if(n<=1) {
            return n;
        }
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }
        long nthFIbonaccinumber = (fibonacci(n - 1) + fibonacci(n -2));
        fibonacciCache[n] = nthFIbonaccinumber;
        return nthFIbonaccinumber;
    }
}
