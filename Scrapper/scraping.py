from selenium import webdriver #Librería de selenium para usar el driver de Edge
from selenium.webdriver.common.by import By #Librería de selenium para buscar por xpath
from time import sleep #Librería para tomar un tiempo de espera
import pandas as pd #Librería pandas para hacer csv

#Se busca el fabricante en el sitio
search = input("Ingresa el fabricante a buscar ")
#Se ingresa el número de páginas existentes del fabricante en el sitio
paginas = input("Ingresa el número de páginas que desea ")
#Se pide el número de fabricante
fab = input("Ingresa el número de fabricante para el sistema ")
#Se ingresa un nombre al documento csv
nom_cvs = input("Ingresa un nombre para el csv resultante ")

driver = webdriver.Edge("/msedgedriver.exe") #Se asigna el driver de Edge a la variable
driver.get('https://www.anixter.com/es_mx/login') #Se le da una url para iniciar el driver en es página

#Se crean las credenciales
#user = 'said.venoso@telmedia.com.mx' 
#psw = 'c'

#Se encuentran los inputs que piden credenciales
#input_user = driver.find_element(By.XPATH,'//*[@id="j_username"]')
#input_pass = driver.find_element(By.XPATH,'//*[@id="j_password"]')

#Se escriben las credenciales en los inputs
#input_user.send_keys(user)
#input_pass.send_keys(psw)

#Se encuentra y da clik en el botón "login"
#boton = driver.find_element(By.XPATH,'//*[@id="loginForm"]/div[2]/div[2]/button')
#boton.click()
sleep(60)

#Se encuentra el input de la barra de busqueda y se le pasa el fabricante a buscar
input_search = driver.find_element(By.XPATH,'//*[@id="search-desktop"]')
input_search.send_keys(search)

#Se encuentra el botón de busqueda y se le da clik
search_boton = driver.find_element(By.XPATH,'//*[@id="header-mega-search-desktop"]/button')
search_boton.click()

#Se añade un tiempo de espera para que cargue por completo la página principal
sleep(5)

#Se verifica si la pagina es de productos o search
url = 'https://www.anixter.com/es_mx/products'
url1 = 'https://www.anixter.com/es_mx/search'
es_prod = driver.current_url
es_corte = es_prod[:38]
es_corte1 = es_prod[:36]
if es_corte1 != url1:
    if es_corte != url:
        boton_prod = driver.find_element(By.XPATH,'//div[@class="button parbase section"]/a')
        boton_prod.click()
        sleep(5)
    

#Se crean las listas donde se van a almacenar los datos de los productos
n = list()
f = list()
n_pa = list()
n_pa_prov = list()
pre = list()
i = list()
u = list()
n_fab = list()
anixter = list()
fac_un = list()
inv = list()
moneda = list()

#Contador de páginas y de productos
cont_pag = 0
cont_prod = 0
cont = 1
    
#Mientras el if sea verdadero se aplica un Do While
while True:
    productos = driver.find_elements(By.XPATH,'//li[@class="product-tile-tertiary row"]') #Se optiene la lista de productos
    
    for prod in productos: #For que recorre la lista de los productos uno por uno
        if es_corte1 == url1:
            esp_npp = prod.find_element(By.XPATH,'//*[@id="resultsList"]/ul/li['+str(cont)+']/div[1]/div/p[3]/span').text
        else:
            esp_npp = prod.find_element(By.XPATH,'//*[@id="page"]/div[6]/div[2]/div[2]/div/div[3]/ul/li['+str(cont)+']/div[1]/div/p[3]/span').text
        esp_np = prod.find_element(By.XPATH,'.//span[@class="value"]').text
        n.append(prod.find_element(By.XPATH,'.//p[@class="title-primary"]').text.replace("\n"," ")) #Se obtiene una lista de nombres de los productos
        f.append(prod.find_element(By.XPATH,'.//p[@class="title-secondary"]').text) #Se obtiene una lista de fabricantes de los productos
        if esp_np[0] == " ":
            esp_np1 = esp_np[1:esp_np.__len__()]
            n_pa.append(esp_np1)
        else:
            n_pa.append(esp_np)
        
        if esp_npp[0] == " ":
            esp_npp1 = esp_npp[1:esp_npp.__len__()]
            n_pa_prov.append(esp_npp1)
        else:
            n_pa_prov.append(esp_npp)
        if es_corte1 == url1:
            if prod.find_element(By.XPATH,'//*[@id="resultsList"]/ul/li['+str(cont)+']/div[2]/p[1]/div/span[2]/em').text == 'Solicitar Cotización ':
                pre.append("")
            else:
                pre.append(prod.find_element(By.XPATH,'//*[@id="resultsList"]/ul/li['+str(cont)+']/div[2]/p[1]/div/span[2]/em').text.replace("$",""))
        else:
            if prod.find_element(By.XPATH,'//*[@id="page"]/div[6]/div[2]/div[2]/div/div[3]/ul/li['+str(cont)+']/div[2]/p[1]/div/span[2]/em').text == 'Solicitar Cotización ':
                pre.append("")
            else:
                pre.append(prod.find_element(By.XPATH,'//*[@id="page"]/div[6]/div[2]/div[2]/div/div[3]/ul/li['+str(cont)+']/div[2]/p[1]/div/span[2]/em').text.replace("$","")) #Se obtiene lista de precios de los productos
        
        i.append(prod.find_element(By.XPATH,'.//span[@class="stock-detail"]').text.replace(",","")) #Se obtiene el estock de anixter de cada producto
        cont_prod = cont_prod + 1 #Se incrementa el contador de productos
        cont = cont + 1
    
    cont_pag = cont_pag +1 #Se incrementa el contador de paginas
    
    if int(paginas) == 1:
        break
    else:
        if cont_pag < int(paginas): #Si el contador es menor al número de paginas que se tiene del fabricante buscado
            botons = driver.find_element(By.XPATH,'//li[@class="next"]') #Se busca el botón siguiente
            botons.click() #Se da click sobre el botón siguiente
            sleep(10) #Se dan 5 segundos de espera para que se cargen en totalidad los datos
            cont = 1
        else: #Si el contador no es menor que el número de página que se tiene del fabricante buscado le da break al While
            break

for numero in i:
    if "Feet" in numero:
        u.append("FT")
        fac_un.append("")
    elif "Each" in numero:
        u.append("EA")
        fac_un.append("1")
    elif "Roll" in numero:
        u.append("BB")
        fac_un.append("")
    elif "Pack" in numero:
        u.append("PK")
        c=numero[0]
        c1=numero[0:1]
        c2=numero[0:2]
        c3=numero[0:3]
        c4=numero[0:4]
        c5=numero[0:5]
        c6=numero[0:6]
        c7=numero[0:7]
        if c6.isdigit() == True:
            fac_un.append(c7)
        elif c6.isdigit() == True:
            fac_un.append(c6)
        elif c5.isdigit() == True:
            fac_un.append(c5)
        elif c4.isdigit() == True:
            fac_un.append(c4)
        elif c3.isdigit() == True:
            fac_un.append(c3)
        elif c2.isdigit() == True:
            fac_un.append(c2)
        elif c1.isdigit() == True:
            fac_un.append(c1)
        elif c.isdigit() == True:
            fac_un.append(c)
    elif "Meter" in numero:
        u.append("MT")
        fac_un.append("")
    else:
        u.append("NOP")
    c=numero[0]
    c1=numero[0:1]
    c2=numero[0:2]
    c3=numero[0:3]
    c4=numero[0:4]
    c5=numero[0:5]
    c6=numero[0:6]
    c7=numero[0:7]
    if c6.isdigit() == True:
        inv.append(c7)
    elif c6.isdigit() == True:
        inv.append(c6)
    elif c5.isdigit() == True:
        inv.append(c5)
    elif c4.isdigit() == True:
        inv.append(c4)
    elif c3.isdigit() == True:
        inv.append(c3)
    elif c2.isdigit() == True:
        inv.append(c2)
    elif c1.isdigit() == True:
        inv.append(c1)
    elif c.isdigit() == True:
        inv.append(c)

for nfab in f:
    if "BARCO" in f:
        n_fab.append("463")
    elif "BELDEN" in f:
        n_fab.append("39")
    elif "CORNING" in f:
        n_fab.append("40")
    elif "AXIS COMMUNICATIONS" in f:
        n_fab.append("1")
    elif "PANDUIT" in f:
        n_fab.append("42")
    elif "COMMSCOPE SYSTIMAX" in f:
        n_fab.append("24")
    else:
        n_fab.append(fab)

for axt in range(cont_prod):
    anixter.append("3")
    moneda.append("2")

#Se crea el frame donde se formatea y posteriormente se crea el csv
tabla = pd.DataFrame({'Description_tmp': n, 'Fabricante' : f, 'IdProducto_NoParte': n_pa,
'ID_producto_proveedor': n_pa_prov,'precio_de_proveedor' : pre,'Stock' : i,'Existencias' : inv,
'Unidad' : u, 'ID_Fabricante' : n_fab, 'FU' : fac_un, 'ID_Proveedor' : anixter,'id_moneda' : moneda},
index=list(range(1,int(cont_prod)+1)))

tabla.to_csv(nom_cvs+'.csv',index=False)
