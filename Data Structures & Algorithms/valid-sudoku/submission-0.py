class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        digits = set("123456789")

        for i in range(9):
            row = [x for x in board[i] if x != "."]
            col = [board[j][i] for j in range(9) if board[j][i] != "."]

            if len(row) != len(set(row)):
                return False

            if len(col) != len(set(col)):
                return False

        for r in range(0, 9, 3):
            for c in range(0, 9, 3):
                box = [
                    board[i][j]
                    for i in range(r, r + 3)
                    for j in range(c, c + 3)
                    if board[i][j] != "."
                ]

                if len(box) != len(set(box)):
                    return False

        return all(
            cell == "." or cell in digits
            for row in board
            for cell in row
        )
