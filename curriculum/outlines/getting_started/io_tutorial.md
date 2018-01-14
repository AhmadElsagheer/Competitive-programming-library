# Java I/O Guide

The contract between the problem solver and the online judge is based on taking the input and writing the output in specific formats.

### Input Reading

- The main two input readers in java are:
  1. Scanner
    ```java
    Scanner sc = new Scanner(System.in);
    // available methods: nextLine(), next(), nextInt(), nextLong(). See java docs for what they return.
    ```
  2. BufferedReader
    ```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // available method: readLine(). Equivalent to nextLine() in Scanner.
    ```
- If we have an input that looks like:
  ```
  1 3
  100000000000
  myString
  ```
  Using Scanner, you can parse it as follows:
  ```java
  int x = sc.nextInt(), y = sc.nextInt();
  long z = sc.nextLong();
  String s = sc.next();
  ```

  Using BufferedReader, you can parse it as follows:
  ```
  StringTokenizer st = new StringTokenizer(br.readLine());
  int x = Integer.parseInt(st.nextToken());
  int y = Integer.parseInt(st.nextToken());
  long z = Long.parseLong(br.readLine());
  String s = br.readLine();
  ```

- The judge runs the code against test cases using input files. The problem statement must specify how the input file will look like. Common input file formats are:
  1. The file consists of one or more test cases where the number of test cases is given on the first line of the file.
  2. The file consists of multiple test cases and there will be a character that indicates the end of file. For example, a line containing a single `0`. In such case, you should terminate immediately and stop reading any more input.
  3. The file consists of multiple test cases and nothing to indicate the end of file. In such case, you have to read till *End Of File (EOF)* (the file has no more lines to read). You can check EOF in multiple ways:
      - Read a new line (`sc.nextLine()` or `br.readLine()`) and if the returned value is `null`, then you reached EOF.
      - Use input readers functions such as `br.ready()` or `sc.hasNext()` which returns false if EOF is reached.

- BufferedReader is much more faster than Scanner. Only use the Scanner in case of small inputs (n < 1e5).
- You can implement your own Scanner class to help you get rid of the tedious syntax of using the BufferedReader and the StringTokenizer. This class will have a BufferedReader and a StringTokenizer as its instance variables and some methods similar to that of a Scanner (`nextInt()`, `ready()`,...).

### Output Formatting
- Three ways to print the output:
  1. `System.out.println()`: slow a little bit (because every print statement flushes to the output file)
  2. PrintWriter: faster
    ```java
    PrintWriter out = new PrintWriter(System.out);
    out.println("hello");  // it has the same functions as System.out (print(), println(), printf())
    out.flush();    // you have to flush only once at the end of your code. Did you get why it is faster ;) ?
    ```
  3. StringBuilder: fast as PrintWriter
      ```java
      StringBuilder sb = new StringBuilder();
      sb.append("hello").append("\n");
      System.out.print(sb);
      ```
- Some examples to efficiently format your output:
    - Print [`7`, `days`, `24`] space-separated on a single line where `24` should have exactly 5 decimal places. 
        ```java
        out.printf("%d %s %.5f\n", 7, "days", 24);
        ```
    - Print strings = [`hello`, `world`, `I'm here!`] each on a separate line.
        ```java
        for(String s: strings)
            out.println(s);
        ```
    - Print strings = [`hello`, `world`, `I'm here!`] each on a separate line and each followed by a blank line.
        ```java
        for(String s: strings) {
            out.println(s);
            out.println();
        }
        ```

    - Print strings = [`hello`, `world`, `I'm here!`] each on a separate line. Separate them with blank lines.
        ```java
        boolean first = true;
        for(String s: strings) {
            if(first)
                first = false;
            else
                out.println();
            out.println(s);
        }
        ```
