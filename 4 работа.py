a = int(input("ввведите число а: "))
b = int(input("введите число b: "))
if a < b:
    for i in range(a, b+1):
        print(i)
else:
    print("ошибка")
