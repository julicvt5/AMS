# ejercicio para crear un archivo de excel sin Datos
from openpyxl import Workbook # MODULO 

filesheet = "./Resumen1.xlsx"  # variable para escribir la ruta en donde deseo guardar el archivo( carpeta templates) , y para crear el nombre del excel 

wb = Workbook()

wb.save(filesheet) # objeto, metodo guardar, pasandole como argumento la ruta que esta en la variable filesheet




