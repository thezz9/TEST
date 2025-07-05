y, m = map(int, input().split())  # y: year, m: month

days = [0, 31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31]

# 윤년이면 2월을 29일로
if (y % 4 == 0 and y % 100 != 0) or (y % 400 == 0):
    days[2] = 29

print(days[m])
