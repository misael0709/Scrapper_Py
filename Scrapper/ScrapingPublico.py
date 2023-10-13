from selenium import webdriver #Librería de selenium para usar el driver de Chrom
from selenium.webdriver.common.by import By #Librería de selenium para buscar por xpath
from time import sleep #Librería para tomar un tiempo de espera
from selenium.webdriver.common.keys import Keys #Librería para poder hacer eventos desde teclado
import pandas as pd #Librería pandas para hacer csv


search = input("Ingresa el fabricante a buscar ")
nom_cvs = input("Ingresa un nombre para el csv resultante ")

driver = webdriver.Chrome('./chromedriver.exe') #Se asigna el driver de Chrome a la variable
driver.get('https://telmedia.com.mx') #Se le da una url para iniciar el driver en es página
sleep(5)

input_search = driver.find_element(By.XPATH,'/html/body/header/div/div[2]/nav/ul/li[1]/a')
input_search.send_keys(Keys.ENTER)
sleep(5)

#input_search.send_keys(search)

#search_boton = driver.find_element(By.XPATH,'.//button[@class="dgwt-wcas-search-submit"]')

#nombre = list()
#precio = list()

#cont = 1

#for prod in range(9):
#    nombre.append(driver.find_element(By.XPATH,'//*[@id="main"]/ul/li['+str(cont)+']/a[1]/h2').text)
#    precio.append(driver.find_element(By.XPATH,'//*[@id="main"]/ul/li['+str(cont)+']/a[1]/span/span/bdi').text)
#    cont = cont + 1

#tabla = pd.DataFrame({'Nombre':nombre,'Precio':precio},index=list(range(9)))
#tabla.to_csv(nom_cvs+'.csv',index=False)