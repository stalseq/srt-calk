import java.util.Scanner;
;
//(a % 400 == 0) || (a % 4 == 0 && a % 100 != 0)
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        System.out.print(calk(a));
    }

    public static String calk(String x) throws Exception {


        String[] b;
        char A;
        String res = null;


        if (x.contains(" + ")) {
            b = x.split(" \\+ ");
            A = '+';
        } else if (x.contains(" - ")) {
            b = x.split(" - ");
            A = '-';
        } else if (x.contains(" * ")) {
            b = x.split(" \\* ");
            A = '*';
        } else if (x.contains(" / ")) {
            b = x.split(" / ");
            A = '/';
        } else {
            throw new Exception("Не правильный знак действия");
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i].replace("\"", "");
            b[i] = b[i].replace(" ", "");
            if (b[i].length() > 10) {
                throw new Exception("Длина строки не может превышать 10 символов");
            }
        }
        if (A == '*' || A == '/') {
            if (b[1].contains("\"")) {
                throw new Exception("Деление или умножение должно быть только на число");
            }
        }

        if (A == '+') {
            res = b[0] + b[1];
            return "\"" + res + "\"";
        } else if (A == '*') {
            int s = Integer.parseInt(b[1]);
            if (s >= 10 || s <= 1) throw new Exception("Умножать можно только на числа не бельше 10");
            String g = "";
            for (int i = 0; i < s; i++) {
                g = g + b[0];
            }
            if (g.length() > 40) {
                return "\"" + g.substring(0, 40) + "..." + "\"";
            } else {
                return "\"" + g + "\"";
            }
        }
        if (A == '-') {
            int index = b[0].indexOf(b[1]);
            if (index == -1) {
                return "\"" + b[0] + "\"";
            } else {
                String res1 = b[0].substring(0, index);
                res1 += b[0].substring(index + b[1].length());
                return "\"" + res1 + "\"";

            }
        }
        if (A == '/') {
            int x1 = b[0].length() / Integer.parseInt(b[1]);
            String res1 = b[0].substring(0, x1);
            if (x1 >10 || x1 <1){ throw new Exception("Деление может быть на числа от 1 до 10");}
            return "\"" + res1 + "\"";
        }


        return res;
    }

}
































        /*      int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] x = new int[a];
        for (int i = 0; i < a; i++) {
            x[i] = scanner.nextInt();
        }
       // for (int i = 0; i < b; i++) {
          //  int temp = x[x.length - 1];
            for (int j = x.length - 1; j > 0; j--){
                x[j] = x[x.length - 1];
          //  x[0] = temp;
        }

        for (int j : x) {
            System.out.print(j + " ");
        }


            }

        }

*/












        /*if (b%10 == 0) {
            for (int i = 0; i < b; i++) {
                int temp = x[x.length - 1];
                for (int j = x.length - 1; j > 0; j--)
                    x[j] = x[j - 1];
                x[0] = temp;
            }

            for (int j : x) {
                System.out.print(j + " ");
            }
        }
    }
}*/




