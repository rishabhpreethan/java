class Demo:
    def __init__(self,str):
        self.name = str
    def print_Demo(self):
        print(self.name)

obj1 = Demo("IITM")
obj2 = Demo("Java")
obj1.print_Demo()
obj2.print_Demo()