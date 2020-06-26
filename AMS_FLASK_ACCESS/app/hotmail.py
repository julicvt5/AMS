#IMPORTANTE codificar el script en UTF-8
import smtplib, getpass, os
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email.encoders import encode_base64

print("**** Enviar email con Hotmail ****")
user = input("Cuenta de hotmail: ")
password = getpass.getpass("Password: ")

#Para las cabeceras del email
remitente = input("From, ejemplo: administrador <admin@hotmail.com>: ")
destinatario = input("To, ejemplo: amigo <amigo@mail.com>: ")
asunto = input("Subject, Asunto del mensaje: ")
mensaje = input("Mensaje HTML: ")
archivo = input("Adjuntar archivo: ")

#Host y puerto SMTP de Hotmail
hotmail = smtplib.SMTP('smtp.live.com', 25)

#protocolo de cifrado de datos utilizado por Hotmail
hotmail.starttls()

#Credenciales
hotmail.login(user, password)

#muestra la depuración de la operacion de envío 1=true
hotmail.set_debuglevel(1)

header = MIMEMultipart()
header['Subject'] = asunto
header['From'] = remitente
header['To'] = destinatario

mensaje = MIMEText(mensaje, 'html') #Content-type:text/html
header.attach(mensaje)

if (os.path.isfile(archivo)):
 adjunto = MIMEBase('application', 'octet-stream')
 adjunto.set_payload(open(archivo, "rb").read())
 encode_base64(adjunto)
 adjunto.add_header('Content-Disposition', 'attachment; filename="%s"' % os.path.basename(archivo))
 header.attach(adjunto)

#Enviar email
hotmail.sendmail(remitente, destinatario, header.as_string())

#Cerrar la conexión SMTP
hotmail.quit()