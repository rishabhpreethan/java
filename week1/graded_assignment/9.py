def elementSum(n):
     sum = 0
     while (n != 0):
           sum = sum + n % 10
           n = n // 10
     return sum
num = 22
x = elementSum(num)

print(num,x)