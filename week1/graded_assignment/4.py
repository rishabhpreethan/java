def fun1(x):
    y = x+1
    def fun2(z):
        z = ((x+y)*(x-y))*z
        print(z)
    fun2(2)
fun1(5)