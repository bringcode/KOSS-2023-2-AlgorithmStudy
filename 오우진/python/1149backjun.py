n = int(input())
lis = [list(map(int, input().split())) for i in range(n)]
inds = [4]
dp = [0 for i in range(n+1)]

def f(li, i, inds, back):
    ind = li.index(min(li))
    min_value = min(li)
    if ind != inds[i-1] and not back:
        inds.append(ind)
        return dp[i-1] + min_value, inds
    else:
        a = [0,1,2]
        a.remove(ind)
        if li[a[0]] < li[a[1]]:
            ind = a[0]
        else:
            ind = a[1]
        result1 = dp[i-1] + li[ind]
        inds.append(ind)
        if ind == inds[i-1]:
            prev_result, inds2 = f(lis[i-2], i-1, inds[:-2], True)
            result2 = prev_result + min_value
        else:
            return result1, inds
        if result1 < result2:
            return result1, inds
        else:
            return result2, inds2

for i, li in enumerate(lis):
    dp[i+1], inds = f(li, i+1, inds, False)
print(inds,dp[i+1])