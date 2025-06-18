import java.io.*;
import java.util.*;
import java.util.regex.*;

class Calculator {
    private static final String HISTORY_FILE = "savetxt.txt";
    private static final List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        loadHistory();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nКалькулятор. Доступные операции: + - * / // % ^ | |");
                System.out.println("Введите уравнение (или 'history' для просмотра истории, 'exit' для выхода):");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("exit")) {
                    saveHistory();
                    break;
                } else if (input.equalsIgnoreCase("history")) {
                    showHistory();
                    continue;
                } else if (input.equalsIgnoreCase("clear")) {
                    clearHistory();
                    continue;
                }
                
                try {
                    double result = evaluateExpression(input);
                    System.out.println("Результат: " + result);
                    String entry = input + " = " + result;
                    history.add(entry);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }
    }

    private static double evaluateExpression(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", "");
        expression = processAbsoluteValues(expression);
        expression = processParentheses(expression);
        expression = processOperations(expression, new String[]{"\\^"});
        expression = processOperations(expression, new String[]{"\\*", "/", "%", "//"});
        expression = processOperations(expression, new String[]{"\\+", "-"});
        return Double.parseDouble(expression);
    }

    private static String processAbsoluteValues(String expr) throws Exception {
        Pattern pattern = Pattern.compile("\\|([^|]+)\\|");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            String inside = matcher.group(1);
            double value = evaluateExpression(inside);
            expr = expr.replace(matcher.group(), String.valueOf(Math.abs(value)));
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }

    private static String processParentheses(String expr) throws Exception {
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            String inside = matcher.group(1);
            double value = evaluateExpression(inside);
            expr = expr.replace(matcher.group(), String.valueOf(value));
            matcher = pattern.matcher(expr);
        }
        
        if (expr.contains("(") || expr.contains(")")) {
            throw new Exception("Непарные скобки в выражении");
        }
        
        return expr;
    }

    private static String processOperations(String expr, String[] operations) throws Exception {
        String operationPattern = String.join("|", operations);
        Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)(?<!\\^)(" + operationPattern + ")(-?\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            double left = Double.parseDouble(matcher.group(1));
            String op = matcher.group(2);
            double right = Double.parseDouble(matcher.group(3));
            double result = performOperation(left, op, right);
            expr = expr.replaceFirst(Pattern.quote(matcher.group(1)) + op + Pattern.quote(matcher.group(3)), 
                        String.valueOf(result));
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }

    private static double performOperation(double left, String op, double right) throws Exception {
        switch (op) {
            case "+" -> {
                return left + right;
            }
            case "-" -> { 
                return left - right;
            }
            case "*" -> {
                return left * right;
            }
            case "/" -> {
                if (right == 0) throw new ArithmeticException("Деление на ноль");
                return left / right;
            } 
            case "//" -> {
                if (right == 0) throw new ArithmeticException("Деление на ноль");
                return Math.floorDiv((long)left, (long)right);
            }
            case "%" -> {
                return left % right;
            }
            case "^" -> {
                return Math.pow(left, right);
            }
            default -> throw new Exception("Неизвестная операция: " + op);
        }
    }

    private static void loadHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
        }
    }

    private static void saveHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Не удалось сохранить историю: " + e.getMessage());
        }
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
            return;
        }
        
        System.out.println("\nИстория операций:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i+1) + ". " + history.get(i));
        }
    }

    private static void clearHistory() {
        history.clear();
        try {
            new FileWriter(HISTORY_FILE, false).close();
            System.out.println("История очищена.");
        } catch (IOException e) {
            System.out.println("Не удалось очистить файл истории: " + e.getMessage());
        }
    }
}