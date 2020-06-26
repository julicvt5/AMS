import pdfkit
path_wkhtmltopdf = r'C:\Program Files\wkhtmltopdf\bin\wkhtmltopdf.exe'
config = pdfkit.configuration(wkhtmltopdf=path_wkhtmltopdf )
#pdfkit.from_url("https://www.google.com/", "informe.pdf", configuration=config)
pdfkit.from_file("informePDF.html", "informe.pdf", configuration=config)