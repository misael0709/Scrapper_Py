from selenium import webdriver #Librería de selenium para usar el driver de Chrom
from selenium.webdriver.common.by import By #Librería de selenium para buscar por xpath
from time import sleep #Librería para tomar un tiempo de espera
from selenium.webdriver.common.keys import Keys #Librería para poder hacer eventos desde teclado
import pandas as pd #Librería pandas para hacer csv


search = input("Ingresa el fabricante a buscar ")
nom_cvs = input("Ingresa un nombre para el csv resultante ")

driver = webdriver.Chrome('./chromedriver.exe') #Se asigna el driver de Chrome a la variable
driver.get('https://store.telmedia.com.mx/shop') #Se le da una url para iniciar el driver en es página

#Se crean las credenciales
#user = 'Pruebas' 
#psw = 'KapDH#OChnhp4VlRcEPXZ1P2'

#Se encuentran los inputs que piden credenciales
#input_user = driver.find_element(By.XPATH,'//*[@id="user_login"]')
#input_pass = driver.find_element(By.XPATH,'//*[@id="user_pass"]')

#Se escriben las credenciales en los inputs
#input_user.send_keys(user)
#input_pass.send_keys(psw)

#Se encuentra y da clik en el botón "login"
#boton = driver.find_element(By.XPATH,'//*[@id="wp-submit"]')
#boton.click()
#sleep(5)
sleep(15)
input_search = driver.find_element(By.XPATH,'//*[@id="dgwt-wcas-search-input-1"]')
input_search.send_keys(search)
input_search.send_keys(Keys.ENTER)
sleep(5)

#search_boton = driver.find_element(By.XPATH,'.//button[@class="dgwt-wcas-search-submit"]')

nombre = list()
precio = list()

cont = 1

for prod in range(9):
    nombre.append(driver.find_element(By.XPATH,'//*[@id="main"]/ul/li['+str(cont)+']/a[1]/h2').text)
    precio.append(driver.find_element(By.XPATH,'//*[@id="main"]/ul/li['+str(cont)+']/a[1]/span/span/bdi').text)
    cont = cont + 1

tabla = pd.DataFrame({'Nombre':nombre,'Precio':precio},index=list(range(9)))
tabla.to_csv(nom_cvs+'.csv',index=False)