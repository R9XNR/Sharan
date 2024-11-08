N = 3

A = [
[1, 2, 3],
[4, 5, 6],
[7, 8, 9]]

a = 0
b = 0
for i in range(N):
    for j in range(i + 1, N):
        if A[i][j] > 0:
            b += A[i][j]
            a += 1
print("сумма", b)
print("число положительных элементов:",a)

