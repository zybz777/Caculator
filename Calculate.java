package Calculator;

public class Calculate {

    // 判断符号的合法性
    public static boolean checkInput(String input) {
        if ((input.charAt(0) == '-') && (input.charAt(1) != '+' || input.charAt(1) != '*' || input.charAt(1) != '/')) {
            return true;
        }
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                // 运算符处于最后一位 格式错误
                if (i == input.length() - 1) {
                    return false;
                }
                if (input.charAt(i + 1) == '+' || input.charAt(i + 1) == '-' || input.charAt(i + 1) == '*'
                        || input.charAt(i + 1) == '/') {
                    return false;
                }
            }
        }
        return true;
    }

    // 计算结果
    public static String answer(String input) {
        String[] numbers = new String[2];
        double ans = 0; // 记录结果
        boolean flag = true;// 记录式子中有无加减运算符

        // 递归出口 input中不含运算符
        if ((!input.contains("+")) && (!input.contains("-")) && (!input.contains("*")) && (!input.contains("/"))) {
            ans = ans + Double.parseDouble(input);
        }

        // 算式中有加减，先以加减号进行递归
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                numbers[0] = input.substring(0, i);
                numbers[1] = input.substring(i + 1, input.length());
                ans = ans + Double.parseDouble(answer(numbers[0])) + Double.parseDouble(answer(numbers[1]));
                flag = false;
                break;
            } else if (input.charAt(i) == '-') {
                numbers[0] = input.substring(0, i);
                if (numbers[0].equals("")) {
                    numbers[0] = "0";
                }
                numbers[1] = input.substring(i + 1, input.length());
                // 将numbers[1]中的加减符号取反
                char[] temp = numbers[1].toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == '+') {
                        temp[j] = '-';
                    } else if (temp[j] == '-') {
                        temp[j] = '+';
                    }
                }
                String number1 = new String(temp);
                ans = ans + Double.parseDouble(answer(numbers[0])) + (-1) * Double.parseDouble(answer(number1));
                flag = false;
                break;
            }
        }

        // 算式中无加减，以乘除号进行递归
        for (int i = 0; i < input.length() && flag; i++) {
            if (input.charAt(i) == '*') {
                numbers[0] = input.substring(0, i);
                numbers[1] = input.substring(i + 1, input.length());
                ans = ans + Double.parseDouble(answer(numbers[0])) * Double.parseDouble(answer(numbers[1]));
                break;
            } else if (input.charAt(i) == '/') {
                numbers[0] = input.substring(0, i);
                numbers[1] = input.substring(i + 1, input.length());
                // 将乘除符号取反
                char[] temp = numbers[1].toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == '*') {
                        temp[j] = '/';
                    } else if (temp[j] == '/') {
                        temp[j] = '*';
                    }
                }
                String number1 = new String(temp);
                ans = ans + Double.parseDouble(answer(numbers[0])) * (1 / Double.parseDouble(answer(number1)));
                break;
            }
        }

        String output = String.format("%.3f", ans);// 保留三位小数
        return output;
    }
}
