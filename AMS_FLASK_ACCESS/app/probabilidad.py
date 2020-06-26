from scipy.stats import norm
import matplotlib.pyplot as plt
import numpy as np
import statistics as stats

x = norm.rvs(size=100) # Generar 1000 datos
print(x)
print(stats.mean(x))
#print(stats.std(x))
mean, std = norm.fit(x)
gen = norm(mean, std)
norm_x=gen.rvs(size=5)
print(norm_x)

# Gráfica de los siza datos
#list (range(10))
plt.plot(x, 'o') # 'ro' es para graficar con puntos, 'g^' -> Triangulo, 'bs' -> Cuadrado, 'c', 'd', 'o'
plt.xlabel('x')
plt.ylabel('y')
plt.title('Grafica Beta 1000 datos')
plt.show()

plt.plot(norm_x, 'o') # 'ro' es para graficar con puntos, 'g^' -> Triangulo, 'bs' -> Cuadrado, 'c', 'd', 'o'
plt.xlabel('x')
plt.ylabel('y')
plt.title('Grafica Beta 1000 datos')
plt.show()