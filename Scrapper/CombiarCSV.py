import os
import glob
import pandas as pd
os.chdir("C:/Users/user/Documents/VS Proyectos Telmedia/Scrapper")

extension = 'csv'
todos_los_archivos = [i for i in glob.glob('*.{}'.format(extension))]

#combina todos los archivos de la lista
combinado_csv = pd.concat([pd.read_csv(f) for f in todos_los_archivos ])
#exporta a csv
combinado_csv.to_csv( "combinado_csv.csv", index=False, encoding='utf-8-sig')