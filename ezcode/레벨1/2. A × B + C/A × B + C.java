import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        
        BigInteger A = new BigInteger(tokens[0]);
        BigInteger B = new BigInteger(tokens[1]);
        BigInteger C = new BigInteger(tokens[2]);
        
        // A × B + C 계산
        BigInteger result = A.multiply(B).add(C);
        System.out.println(result);
    }
}