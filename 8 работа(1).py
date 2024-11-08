import math
print("1 - треугольник, 2 - прямоугольник, 3 - круг")
figure = input("выберите фигуру: ")
if figure == '1':
    print("введите длины сторон треугольника: ")
    a = float(input("a :"))
    b = float(input("b :"))
    c = float(input("c :"))
    p = (a + b + c) / 2
    s = math.sqrt(p * (p-a) * (p-b) * (p-c)) 
    print("площадь треугольника равна : %.2f" % s)
elif figure == '2':
    print("введите длины сторон прямоугольника: ")
    a = float(input("a :"))
    b = float(input("b :"))
    print("площадь прямоугольника равна : %.2f" % (a * b))
elif figure == '3':
    r = float(input("введите радиус круга : "))
    print("площадь круга равна : %.2f" % (math.pi * r ** 2))
else:
    print("ошибка")
