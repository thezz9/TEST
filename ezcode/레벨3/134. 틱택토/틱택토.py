def is_win(board, player):
    for i in range(3):
        if all(board[i][j] == player for j in range(3)):
            return True
        if all(board[j][i] == player for j in range(3)):
            return True
    if all(board[i][i] == player for i in range(3)):
        return True
    if all(board[i][2 - i] == player for i in range(3)):
        return True
    return False

board = [list(input()) for _ in range(3)]
o_count = sum(row.count('O') for row in board)
x_count = sum(row.count('X') for row in board)

o_win = is_win(board, 'O')
x_win = is_win(board, 'X')

valid = True
if x_count > o_count or o_count - x_count > 1:
    valid = False
if o_win and x_win:
    valid = False
if o_win and o_count != x_count + 1:
    valid = False
if x_win and o_count != x_count:
    valid = False

print(1 if valid else 0)