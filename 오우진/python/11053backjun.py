n = int(input())
li = list(map(int, input().split()))
dp = [0 for i in range(n)]

for i in range(n):
    max_num = 1
    for ind in range(i):
        if li[ind] < li[i]:
            num = dp[ind] + 1
            if num > max_num:
                max_num = num
    dp[i] = max_num
print(max(dp))