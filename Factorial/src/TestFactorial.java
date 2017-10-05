public class TestFactorial {
    public static void main(String[] args) {
        int n = 5;
        Factorial rec = new Factorial();
        System.out.println(rec.fac(n));
        System.out.println(rec.facTail(n,1));

    }
}

class Factorial{
    public int fac(int n){

        if (n == 0) return 1;
        return n*fac(n-1);
    }
    public int facTail(int n, int result){
        if (n == 0) return result;
        return facTail(n-1,n*result);
    }

}
