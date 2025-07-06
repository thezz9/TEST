year, month = map(int, input().split())

# 각 달의 일 수 (인덱스 0은 사용하지 않음)
days = [0, 31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31]

# 윤년이면 2월을 29일로 설정
if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
    days[2] = 29

print(days[month])