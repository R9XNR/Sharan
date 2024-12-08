with open('Шаран А.А. У-243_vvod.txt', 'r') as fl:
    lines = fl.readlines()

matrix = []
for line in lines:
    cl = line.replace('[', '').replace(']', '').replace(',', '').strip()
    if cl:
        row = list(map(int, cl.split()))
        matrix.append(row)
        
def sorted_ascending(row):
    return all(row[i] <= row[i + 1] for i in range(len(row) - 1))

def sorted_descending(row):
     return all(row[i] >= row[i + 1] for i in range(len(row) - 1))


def max_sorted_item(matrix):
    max_item = float('-inf')
    for row in matrix:
        if sorted_ascending(row) or sorted_descending(row):
            max_item = max(max_item, max(row))
            
    return max_item if max_item != float('-inf') else None

        
result = max_sorted_item(matrix)


def sort_k(matrix, k):
    k_row = matrix[k - 1]
    
    sorted_index = sorted(range(len(k_row)), key=lambda i: k_row[i])

    sorted_matrix = []
    for row in matrix:
        sorted_row = [row[i] for i in sorted_index]
        sorted_matrix.append(sorted_row)
        
    return sorted_matrix

k = int(input('Введите строку матрицы которую нужно отсортировать: '))

sorted_matrix = sort_k(matrix, k)


with open('Шаран А.А. У-243_vivod.txt', 'w', encoding='utf-8') as resfl:
    resfl.write(f"максимальный элемент:{result} \n")
    resfl.write('Матрица с отсортированными столбцами: \n')
    for row in sorted_matrix:
        resfl.write(f'{row} \n')
