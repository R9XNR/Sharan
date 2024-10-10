import math
x=3.981*0.01
y=-1.625*1000
z=0.512
l=(x-1)/(math.sin(z))
s=(2**-x)*(math.sqrt(x+(math.sqrt(abs(y))**(1/4))))*(math.sqrt(math.e**l)**(1/3))
print(s)
