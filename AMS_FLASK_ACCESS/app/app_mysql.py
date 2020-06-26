#app.py es el archivo que permite arrancar la aplicación, sera el archivo inicial de nuestro servidor
# codigo para iniciar servidor.
from flask import Flask, render_template, request, session, logging, redirect, url_for, flash # clase para tener una conexión
from flask_mysqldb import MySQL, MySQLdb 
import MySQLdb.cursors
from flask_bootstrap import Bootstrap
from flask_mysqldb import MySQL
import bcrypt  #libreria para encriptar 
import re
import pyodbc # se instaló pip install pyodbc para poder hacer la conexión con la BD en access

app = Flask(__name__)

#configuración de la base de datos de mysql
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = '123$'
app.config['MYSQL_DB'] = 'amsdb' #nombre de la BD Flask y mi aplicación
app.config['MYSQL_CURSORCLASS'] = 'DictCursor'

mysql = MySQL(app)

#settings
app.secret_key = 'mysecretkey'

#definimos con @app.route las rutas o link de acceso 
@app.route('/')

#-------- CODIGO DE RUTAS PARA ADMIN ----------------

@app.route('/', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def index ():
    if request.method == 'GET':
        #return render_template ("login.html")
        return render_template ("menu_proyecto.html") 
    else:
        #return render_template ("login.html")
        return render_template ("menu_proyecto.html") 
    

@app.route('/login', methods=['GET','POST']) # ruta que mostrara la pagina del login
def login():
  if request.method == 'GET':
      return render_template ("login.html")
  elif request.method =='POST':
       email = request.form['email']
       password = request.form['password'] .encode('utf-8')
       # hash_password = bcrypt.hashpw(password, bcrypt.gensalt()) # para encriptar contraseña
       cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)   # iniciamos la conexion con la BD  
       cur.execute("SELECT*FROM users WHERE email=%s", (email,))
       user = cur.fetchone()
       # cur.close()
       if (len(user)>=1):
           if bcrypt.hashpw(password, user['password'].encode('utf-8'))== user['password'].encode('utf-8'):
               session['nombre']= user['nombre']
               session['email']= user['email']
               cur.execute('INSERT INTO tblogin (email) VALUES (%s)', (email,))
               mysql.connection.commit()
               return render_template ("home.html")
              # return render_template ("admin.html")
       else:
           return "Error password or user"

@app.route('/reg_user', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def reg_user ():
    if request.method == 'GET':
       return render_template ("reg_user.html")
    else: 
        iduser=request.form['iduser']
        nombre = request.form['nombre']
        email = request.form['email']
        password = request.form['password'].encode('utf-8')
        hash_password = bcrypt.hashpw(password, bcrypt.gensalt()) # para encriptar contraseña
        cur = mysql.connection.cursor()
        cur.execute('INSERT INTO users (iduser, nombre, email, password) VALUES (%s, %s, %s, %s)', 
        (iduser, nombre, email, hash_password))
        mysql.connection.commit()
        session['nombre'] = nombre
        session['email'] = emailiduser = request.form['iduser']
        return render_template ("login.html")

@app.route('/home', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def home():
    if request.method == 'GET':        
        return render_template ("home.html")
    else:
        return render_template ("home.html")
        

@app.route('/dashboard', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def dashboard():
    if request.method == 'GET':        
        return render_template ("dashboard.html")

# CÓDIGO MODULO ADMINISTRATIVO ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

@app.route('/admin', methods=['GET','POST'])  # ---------------------------------------------------------------------------------------
def admin ():
    if request.method == 'GET':
       return render_template ("admin.html")
    else:
       return render_template ("admin.html")


@app.route('/etapas', methods=['GET','POST'])  # ---------------------------------------------------------------------------------------
def etapas ():
    if request.method == 'GET':
       return render_template ("etapas.html")
    else:
       return render_template ("etapas.html")


@app.route('/crear_etapas', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def crear_etapas():
    if request.method == 'GET':
        return render_template ("etapas.html") 
    else:
        nombre_etapa = request.form['nombre_etapa']
        email = session['email']
        if (len(nombre_etapa)>=1):
            cur = mysql.connection.cursor()
            cur.execute('INSERT INTO etapas (nom_etapa, nom_usuario) VALUES (%s, %s)', 
            (nombre_etapa, email))
            mysql.connection.commit()
            print (nombre_etapa)
            print (email)
            flash('Datos Guardados exitosamente')
            return render_template ("etapas.html")


@app.route('/editar_etapas', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def editar_etapas():
    cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
    cur.execute('SELECT nom_etapa, nom_usuario FROM etapas')
    result = cur.fetchall()
    return render_template("etapas.html", result = result)


@app.route('/estados', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def estados():
    if request.method == 'GET':
       return render_template ("estados.html")
    else:
        return render_template ("estados.html")
    
@app.route('/crear_estados', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def crear_estados():
    if request.method == 'GET':
        return render_template ("estados.html") 
    else:
        nom_estado = request.form['nom_estado']
        email = session['email']
        if (len(nom_estado)>=1):
            cur = mysql.connection.cursor()    
            cur.execute('INSERT INTO estados (nombre, nom_usuario) VALUES (%s, %s)', 
            (nom_estado, email))
            mysql.connection.commit()
            print (nom_estado)
            print (email)
            flash('Datos Guardados exitosamente')
            return render_template ("estados.html")

@app.route('/editar_estados', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def editar_estados():
    cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
    cur.execute('SELECT nombre, nom_usuario FROM estados')
    result = cur.fetchall()
    return render_template("estados.html", result = result)


@app.route('/sistemas', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def sistemas():
    if request.method == 'GET':
       return render_template ("sistemas.html")                                  
    else:
       return render_template ("sistemas.html")                                  
        
@app.route('/crear_sistemas', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def crear_sistemas():
    if request.method == 'GET':
        return render_template ("sistemas.html") 
    else:
        email = session['email']
        tipo_sistema = request.form['tipo_sistema']
        num_sistema = request.form['num_sistema']
        nom_sistema = tipo_sistema + ' # ' + num_sistema
        if (len(tipo_sistema)>=1) and (len(num_sistema)>=1):
            cur = mysql.connection.cursor()    
            cur.execute('INSERT INTO sistemas (tipo, numero, nombre, nom_usuario ) VALUES (%s, %s, %s, %s)', 
            (tipo_sistema, num_sistema, nom_sistema, email))
            mysql.connection.commit()
            flash('Datos Guardados exitosamente')
            return render_template ("sistemas.html")

@app.route('/editar_sistemas', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def editar_sistemas():
    cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
    cur.execute('SELECT tipo, numero, nombre, nom_usuario FROM sistemas')
    result = cur.fetchall()
    return render_template("sistemas.html", result = result)

@app.route('/user_admin', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def user_admin():
    if request.method == 'GET':
       return render_template ("user_admin.html")                                  
    else:
       return render_template ("user_admin.html")                                  
        
@app.route('/crear_user_admin', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def crear_user_admin():
    if request.method == 'GET':
        return render_template ("user_admin.html") 
    else:
        iduser= request.form['iduser']
        nombre = request.form['nombre']
        email = request.form['email']
        password = request.form['password'].encode('utf-8')
        hash_password = bcrypt.hashpw(password, bcrypt.gensalt()) # para encriptar contraseña
        cur = mysql.connection.cursor()
        cur.execute('INSERT INTO users (iduser, nombre, email, password) VALUES (%s, %s, %s, %s)', 
        (iduser, nombre, email, hash_password))
        mysql.connection.commit()
        session['nombre'] = nombre
        session['email'] = emailiduser = request.form['iduser']
        flash('Datos Guardados exitosamente')
        return render_template ("user_admin.html")

@app.route('/editar_user_admin', methods=['GET','POST']) # ---------------------------------------------------------------------------------------
def editar_user_admin():
    cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
    cur.execute('SELECT iduser, nombre, email FROM users')
    result = cur.fetchall()
    return render_template("user_admin.html", result = result)

@app.route('/componentes', methods=['GET','POST'])
def componentes():
    if request.method == 'POST':
        if request.form.get('Clic') == 'Clic':
            cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
            cur.execute('SELECT nom_etapa, nom_usuario FROM etapas')
            result = cur.fetchall()
            print("Encrypted")
            return render_template("componentes.html", result=result)
        elif  request.form.get('Guardar') == 'Guardar':
            seleccione_etapa = request.form['seleccione_etapa']
            nom_componente = request.form['nom_componente']
            email = session['email']
            cur = mysql.connection.cursor()
            cur.execute('INSERT INTO componentes (nombre, nom_usuario, nom_etapa) VALUES (%s, %s, %s)', 
            (nom_componente , email,  seleccione_etapa))
            mysql.connection.commit()
            print ( nom_componente )
            print (email)
            print (seleccione_etapa)
            flash('Datos Guardados exitosamente')
                            # pass # do something else
            print("Decrypted")
            return render_template("componentes.html")
        else:
                # pass # unknown
            return render_template("componentes.html")
    elif request.method == 'GET':
            # return render_template("index.html")
        print("No Post Back Call")
        return render_template("componentes.html")
    
        
@app.route('/editar_componentes', methods=['GET','POST'])
def editar_componentes():
    cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
    cur.execute('SELECT nombre, nom_etapa, nom_usuario FROM componentes')
    result_comp = cur.fetchall()
    return render_template("componentes.html", result_comp = result_comp) 

 
@app.route('/pozos', methods=['GET','POST'])
def pozos():
    if request.method == 'POST':
        if request.form.get('Clic') =='Ver|Sistema':
           cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
           cur.execute('SELECT nombre, nom_usuario FROM sistemas')
           result = cur.fetchall()
           print("Encrypted")
           return render_template("pozos.html", result=result)
        elif  request.form.get('Guardar') == 'Guardar':
            seleccione_sistema = request.form['seleccione_sistema']
            nom_pozo = request.form['nom_pozo']
            ubicacion_pozo = request.form['ubicacion_pozo']
            email = session['email']
            cur = mysql.connection.cursor()
            cur.execute('INSERT INTO tb_pozos (nombre, ubicacion, sistemas_nombre, nombre_usuario) VALUES (%s, %s, %s, %s)', 
            (nom_pozo, ubicacion_pozo, seleccione_sistema, email))
            mysql.connection.commit()
            flash('Datos Guardados exitosamente')
                            # pass # do something else
            print("Decrypted")
            return render_template("pozos.html")
        else:
                # pass # unknown
            return render_template("pozos.html")
    elif request.method == 'GET':
            # return render_template("index.html")
        print("No Post Back Call")
        return render_template("pozos.html")
    
@app.route('/editar_pozos', methods=['GET','POST'])
def editar_pozos():
    cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
    cur.execute('SELECT nombre, ubicacion, sistemas_nombre, nombre_usuario FROM tb_pozos')
    result_pozo = cur.fetchall()
    return render_template("pozos.html", result_pozo = result_pozo) 
        
@app.route('/proyectos', methods=['GET','POST'])
def proyectos():
    if request.method == 'POST':
        if request.form.get('Clic') == 'Ver|pozo':
            cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
            cur.execute('SELECT nombre, nombre_usuario FROM tb_pozos')
            result = cur.fetchall()
            print("Encrypted")
            return render_template ("proyectos.html", result = result)
        elif  request.form.get('Guardar') == 'Guardar': 
            Descripcion = request.form['Descripcion']
            nom_proyecto = request.form['nom_proyecto']
            fecha_inicial = request.form['fecha_inicial']
            fecha_estimada_fin = request.form['fecha_estimada_fin']
            fecha_real_fin = request.form['fecha_real_fin']
            seleccione_pozo = request.form['seleccione_pozo']
            email = session['email']
            cur = mysql.connection.cursor()
            cur.execute('INSERT INTO proyectos (nombre,  fecha_inicio, fecha_estimada_fin, fecha_real_fin, descripcion,  nom_usuario) VALUES (%s, %s,%s, %s, %s, %s)', 
            (nom_proyecto,  fecha_inicial, fecha_estimada_fin, fecha_real_fin,  Descripcion, email))
            mysql.connection.commit()
            flash('Datos Guardados exitosamente')
            return render_template ("proyectos.html") 
        else:
                    # pass # unknown
            return render_template("proyectos.html")
    elif request.method == 'GET':
            # return render_template("index.html")
        print("No Post Back Call")
        return render_template("proyectos.html")

@app.route('/editar_proyectos', methods=['GET','POST'])
def editar_proyectos():
    cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
    cur.execute('SELECT nombre, descripcion, nom_pozo, fecha_inicio, nom_usuario FROM proyectos')
    result_proy = cur.fetchall()
    return render_template("proyectos.html", result_proy = result_proy) 
# CÓDIGO MODULO PROYECTO ------------------------------------------------------------------------------------------------------------
        

@app.route('/Proyecto', methods=['GET','POST'])
def Proyecto():
    if request.method == 'GET':
        return render_template ("Proyecto.html")

@app.route('/menu_proyecto', methods=['GET','POST'])
def menu_proyecto():
    if request.method == 'GET':
        return render_template ("menu_proyecto.html")
    else:
        return render_template ("menu_proyecto.html")
    

    
@app.route('/datos_proyecto', methods=['GET','POST'])
def datos_proyecto():
    if request.method == 'POST':
        if request.form.get('List') == 'Ver Listado':
            cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
            cur.execute('SELECT nombre FROM proyectos') 
            result_proyecto = cur.fetchall()
            cur.execute('SELECT nombre FROM tb_pozos') # sistemas
            result_pozo = cur.fetchall()
            cur.execute('SELECT nombre FROM sistemas') # sistemas
            result_sistemas = cur.fetchall()
            cur.execute('SELECT nom_etapa FROM etapas') # etapas y componentes
            result_etapa = cur.fetchall()
            cur.execute("SELECT nombre FROM componentes") # etapas y componentes
            result_compo = cur.fetchall()   
            cur.execute('SELECT nombre FROM estados')
            result_estado = cur.fetchall()
            return render_template ("datos_proyecto.html", result_proyecto = result_proyecto,  result_pozo  =  result_pozo ,result_sistemas = result_sistemas, result_etapa = result_etapa,  result_estado=result_estado, result_compo=result_compo )              
        elif  request.form.get('Guardar') == 'Guardar': 
            seleccione_proyecto = request.form['seleccione_proyecto']
            seleccione_pozo = request.form['seleccione_pozo']
            seleccione_sistema = request.form['seleccione_sistema']
            seleccione_etapa = request.form['seleccione_etapa']
            seleccione_componente = request.form['seleccione_componente']
            seleccione_estado = request.form['seleccione_estado']
            fecha_inicial = request.form['fecha_inicial']
            comentarios = request.form['comentarios']
            email = session['email']
            cur = mysql.connection.cursor()
            cur.execute('INSERT INTO resumen (nom_proyecto, nom_sistema, nom_etapa, nom_componente, nom_estado, date_available, comentarios,  nom_usuario) VALUES (%s, %s,%s, %s, %s, %s, %s, %s)', 
            (seleccione_proyecto, seleccione_sistema, seleccione_etapa, seleccione_componente, seleccione_estado, fecha_inicial, comentarios, email))
            mysql.connection.commit()
            flash('Datos Guardados exitosamente')
            return render_template ("datos_proyecto.html") 
        else:
                    # pass # unknown
            return render_template("datos_proyecto.html")
    elif request.method == 'GET':
            # return render_template("index.html")
        print("No Post Back Call")
        return render_template("datos_proyecto.html")
    
@app.route('/consult_datos_proy', methods=['GET','POST'])
def consult_datos_proy():
    if request.method == 'POST':
        if request.form.get('List') == 'Ver Listado':
            cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
            cur.execute('SELECT nombre FROM proyectos') 
            list_proyecto = cur.fetchall()
            return render_template("datos_proyecto.html", list_proyecto=list_proyecto ) 
        elif  request.form.get('Consultar') == 'Consultar':
            selec_proyecto = request.form['selec_proyecto']
            cur = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
            cur.execute("SELECT nom_sistema, nom_pozo, nom_etapa, nom_componente, nom_estado, date_available, comentarios, nom_usuario FROM resumen WHERE nom_proyecto= %s", (selec_proyecto,))
            result_proyecto = cur.fetchall()
            print (result_proyecto)
            return render_template("datos_proyecto.html", result_proyecto = result_proyecto) 
    else:
        return render_template("datos_proyecto.html") 





@app.route('/informe_proyecto', methods=['GET','POST'])
def informe_proyecto():
    if request.method == 'GET':
        return render_template ("informe_proyecto.html")
    else:
        return render_template ("informe_proyecto.html")
    


#-------------------------------------------------------------------- 
if __name__ == '__main__':   #valida que si el archivo inicial corresponde a app.py, entonces corre el servidor en el puerto 3000
   app.secret_key = 'super secret key'
    #app.run(port = 3000, debug =True)
   app.run(debug=True)
