""" import matplotlib.pyplot as plt
import scipy
import scipy.stats
size = 20000
x = scipy.arange(size) # arange, es basada en rangos númericos, genera un vector
print(x)
# creating the dummy sample (using beta distribution)
#Diccionario
#scipy: es el paquete núcleo para rutinas científicas en Python
#int: función devuelve un número entero
#round: función devuelve un número de coma flotante 
#stats : Variable aleatoria
#beta: Una variable beta continua.
#rvs: rvs (a, b, loc = 0, scale = 1, size = 1, random_state = None) Variantes aleatorias., si a>b la grafica se posiciona hacia la izquierda
#loc es la media de la función beta
# scale es la desviación estandar de la función beta
#scipy.stats.beta = Una variable aleatoria beta continua.
#
y = scipy.int_(scipy.round_(scipy.stats.beta.rvs(6,2,size=size)*47))
print(y)
# creating the histogram
h = plt.hist(y, bins=range(48))


dist_names = ['alpha', 'beta', 'arcsine',
              'weibull_min', 'weibull_max', 'rayleigh']

for dist_name in dist_names:
    dist = getattr(scipy.stats, dist_name)
    param = dist.fit(y)
    pdf_fitted = dist.pdf(x, *param[:-2], loc=param[-2], scale=param[-1]) * size
    plt.plot(pdf_fitted, label=dist_name)
    plt.xlim(0,47)
plt.legend(loc='upper left')
plt.show() """

import matplotlib.pyplot as plt
import scipy
import scipy.stats
size = 20000
x = scipy.arange(size)
# creating the dummy sample (using beta distribution)
y = scipy.int_(scipy.round_(scipy.stats.beta.rvs(6,2,size=size)*47))
# creating the histogram
h = plt.hist(y, bins=range(48))

dist_names = ['alpha', 'beta', 'arcsine',
              'weibull_min', 'weibull_max', 'rayleigh']

for dist_name in dist_names:
    dist = getattr(scipy.stats, dist_name)
    param = dist.fit(y)
    pdf_fitted = dist.pdf(x, *param[:-2], loc=param[-2], scale=param[-1]) * size
    plt.plot(pdf_fitted, label=dist_name)
    plt.xlim(0,47)
plt.legend(loc='upper left')
plt.show()