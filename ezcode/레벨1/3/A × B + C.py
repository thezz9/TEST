import sys

def main():
    A, B, C = map(int, sys.stdin.readline().split())
    print(A * B + C)

if __name__ == "__main__":
    main()