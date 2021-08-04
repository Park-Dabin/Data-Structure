public class FibonacciFunc {
    static int Fibo(int n){
        if(n==1)
            return 0;
        else if(n==2)
            return 1;
        else
            return Fibo(n-1) + Fibo(n-2);
    }
    public static void main(String[] args) {
        for(int i = 1; i<15; i++) //n=0일 경우는 없으므로 오류가 뜸
            System.out.print(Fibo(i) + " ");
    }
}
