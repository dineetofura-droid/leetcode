class Solution:
    def solveSudoku(self, board):
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]
        empty = []

        for i in range(9):
            for j in range(9):
                c = board[i][j]
                if c == '.':
                    empty.append((i, j))
                else:
                    rows[i].add(c)
                    cols[j].add(c)
                    boxes[(i // 3) * 3 + j // 3].add(c)

        def solve(pos):
            if pos == len(empty):
                return True

            i, j = empty[pos]
            b = (i // 3) * 3 + j // 3

            for c in '123456789':
                if c not in rows[i] and c not in cols[j] and c not in boxes[b]:
                    board[i][j] = c
                    rows[i].add(c)
                    cols[j].add(c)
                    boxes[b].add(c)

                    if solve(pos + 1):
                        return True

                    board[i][j] = '.'
                    rows[i].remove(c)
                    cols[j].remove(c)
                    boxes[b].remove(c)

            return False

        solve(0)