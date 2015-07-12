package lib;

import java.io.*;
import java.util.StringTokenizer;

public class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public InputReader(File f) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(f));
        tokenizer = null;
    }
    public String next(){
        String str = null;
        while ((tokenizer == null || !tokenizer.hasMoreTokens())) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }


    public char[] nextChar() {
        try {
            return reader.readLine().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: optimise return value for error case
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
