N = 3
M = 4

A = [
[12,11,9,10],
[8, 7, 6, 5],
[4, 3, 2, 1]]

for i in range(N):
    i_min = 0
    v_min = A[i][0]
    for j in range(M):
        if A[i][j] < v_min:
            i_min = j
            v_min = A[i][j]
            tmp = A[i][0]
            A[i][0] = A[i][i_min]
            A[i][i_min] = tmp

for i in range(N):
    i_max = 0
    v_max = A[i][0]
    for j in range(M):
        if A[i][j] > v_max:
            i_max = j
            v_max = A[i][j]
            tmp = A[i][M-1]
            A[i][M-1] = A[i][i_max]
            A[i][i_max] = tmp

for i in range(N):
    for j in range(M):
        print("%2d " % A[i][j], end='')
        print()
