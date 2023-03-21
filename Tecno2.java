import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Tecno2 {
    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScanner sc = new FastScanner();
        int counter = 0;
        int d = 0; //numero de palabras que terminan con d
        int r = 0; //numero de palabras que empiezan con r

        int f = sc.nextInt();
        int n = f;
        List<String> allNames =new ArrayList<String>();
        boolean flag = true;
        boolean firstChar = true;

        while(f-- > 0) {
            String name = sc.nextLine();
            allNames.add(name);
        }

        for (String name: allNames) {
            firstChar = true;

            for (char chars: name.toCharArray()) {

                if(firstChar)
                {
                    if(chars == 'D'){
                        flag = false;
                        firstChar = false;
                    }
                    else if (chars == 'R') {
                        flag = true;
                        firstChar = false;
                        r++;
                    }
                }
                else{
                    if(chars == 'D' && flag==true){
                        flag = false;
                    }
                    else if (chars == 'R' && flag==false) {
                        flag = true;
                        counter++;
                    }
                }
            }

            if(flag == false)
            {
                d++;
            }

        }
        if (Math.min(d ,r) == n){
            counter--;
        }

        counter = counter + Math.min(d ,r) ;

        pw.println(counter);

        pw.close();
    }

    static class FastScanner {
        private final int BS = 1 << 16;
        private final char NC = (char) 0;
        private final byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

    }
}
