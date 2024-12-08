def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)
def compute_expression(x, n):
    return (x ** n) / factorial(n)

x = int(input("Введите число x: "))
n = int(input("Введите число n: "))

result = compute_expression(x, n)
print(f"Результат выражения для x={x} и n={n} равен: {result}")
