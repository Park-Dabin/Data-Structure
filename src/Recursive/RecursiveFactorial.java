public class RecursiveFactorial {
    public static int Factorial(int n){
        if(n == 0)
            return 1; //0!도 1이므로
        else
            return n * Factorial(n-1); //재귀함수이므로 다시 n-1이 함수 처음으로 돌아가는 형태
    }

    public static void main(String[] args) {
        System.out.println("1! = " + Factorial(1));
        System.out.println("2! = " + Factorial(2));
        System.out.println("3! = " + Factorial(3));
        System.out.println("4! = " + Factorial(4));
        System.out.println("9! = " + Factorial(9));
    }
}
