# agregar datos a un excel
from openpyxl import load_workbook, workbook
import pyodbc
import datetime 
connStr = (
    r"DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};"
    r"DBQ=C:\Users\Julieth Carolina\Desktop\INSIGHT\amsdb.accdb;"
    )
cnxn = pyodbc.connect(connStr)
# cur para conexión a BD y ejecutar consultas
cur = cnxn.cursor()

filesheet = "./Resumen_proyecto.xlsx"

wb = load_workbook(filesheet)

sheet = wb.active   

""" sheet['A1'] = "INFORME RESUMEN DE PROYECTOS"
sheet['A2'] = "Proyecto" 
sheet['B2'] = "R.proyecto"
sheet['D2'] = "Pozo"
sheet['E2'] = "R.pozo"
sheet['F2'] = "Sistema"
sheet['G2'] = "R.sistema"
sheet['A4'] = "Etapa"
sheet['B4'] = "R.Etapa"
sheet['F4'] = "Fecha Reporte"
sheet['G4'] = "Hoy"
sheet['A6'] = "Componente"
sheet['B6'] = "Valor"
sheet['C6'] = "Estado"
sheet['D6'] = "Date Available"
sheet['E6'] = "Comentarios"
sheet['F6'] = "Fecha de Registro"
sheet['G6'] = "Usuario que registro Datos" """

cur = cnxn.cursor()
cur.execute('SELECT nom_componente, nom_estado FROM resumen')
result = cur.fetchall()
#print(result)

datos = result

for row in datos:
    for r, row in enumerate(datos):
        row.value=r

    print(row)
    sheet.append(row)
    

wb.save(filesheet)


#"C:\\Users\\user\\Desktop\\demo.xlsx" ejemplo de ruta para guardar excel