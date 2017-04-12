#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#	Rotina criada para gerar um Script de criação de banco de dados MySQL
#	...a partir de um Modelo ER .mwb utilizando o MySQL Workbench.
#
#	Irá chamar as rotinas do Workbench e realizar um pós-processamento, 
#	...deixando o script nos padrões Rech/PWE.
#
#	Criado por Perin em 24/03/2017.
#
#  	Referências:
#  		https://dev.mysql.com/doc/workbench/en/wb-command-line-options.html
#  		https://dev.mysql.com/doc/workbench/en/wb-grt-data-organization.html
#  		http://mysqlworkbench.org/doc/globals/index.html
#		http://mysqlworkbench.org/2009/03/python-scripting-in-workbench/
#         
#   Utilização do cursor para ler metadados:
#   https://dev.mysql.com/doc/connector-python/en/connector-python-api-mysqlcursor-constructor.html
#

# Importações nativas
import os
import sys
import time
import re as regex
# Módulos do Workbench
import grt
from grt.modules import DbMySQLFE as fe

# Buffer de comandos SQL
buffBaseDados=''
# Catálogo do MySQL Workbench
c = None

'''  Executa o dump '''
def executa(geraSaidaPadrao):
	global c
	# Verifica se carregou o modelo
	if not hasattr(grt.root.wb.doc, 'physicalModels'):
		print('-> Tentou gerar DUMP antes da abertura do Modelo (.MWB)')
		sys.exit(-1)

	# Obtém o catálogo do Workbench
	c = grt.root.wb.doc.physicalModels[0].catalog
	# Gera os comandos SQL a partir do modelo .MWB
	fe.generateSQLCreateStatements(c, c.version, {});

	# Obtém o local de saída através da variável de ambiente
	localSaida = os.getenv('SAIDA_SQL')
	# Realiza o DUMP no local de saída definido pelo batch
	print('-> Iniciando geracao do Script SQL...')
	geraDumpProcessando(localSaida + '.sql')
	# Se deve gerar também a saída padrão do Workbench
	if geraSaidaPadrao == True:
		fe.createScriptForCatalogObjects(localSaida + '_WB.sql', c, {})

'''  Executa o dump processando o SQL '''
def geraDumpProcessando(output):
	global buffBaseDados
	global c

	# Percorre schemas (na teoria só tem um)
	for schema in c.schemata:
		buffBaseDados += schema.temp_sql + ';'
		buffBaseDados += '\n\n'
		# Percorre tabelas do schema
		for table in schema.tables:
			buffBaseDados += processTable(schema.name, table.temp_sql)
			buffBaseDados += '\n\n'
	# Grava o buffer gerado em arquivo
	gravaSaidaProcessada(output)
	print('-> Fim da geracao. Confira o arquivo ' + output + '.\n')

'''  Processa uma tabela '''
def processTable(rawSchema, rawSql):
	table=rawSql
	schema = '`' + rawSchema + '`'
	# Remove nome do Schema dos prefixos
	table = regex.sub(schema + r"\.", "", table)
	# Corrige a ambiguidade NULL DEFAULT NULL para NULL
	table = regex.sub(r"NULL DEFAULT NULL", r"NULL", table)
	# Remove sufixo de codificação
	table = regex.sub(r"\nDEFAULT CHARACTER SET = utf8", "", table)
	return table + ';'

''' Grava saída processada no arquivo informado '''
def gravaSaidaProcessada(fileName):
	global buffBaseDados
	# Abre/Cria o arquivo e escreve
	try:
		file=open(fileName, 'w')
		file.write('/* Gerado em ' + time.strftime("%d/%m/%Y %H:%M:%S") + ' por ' + os.getenv('USERNAME') + '. */\n\n')
		file.write(buffBaseDados)
		file.write('/* FIM */')
		file.close()
	except:
		print('-> Falha ao gravar arquivo ' + fileName)
		sys.exit(-1)

# Executa o script gerando a saída padrão do MySQL Workbench
executa(True)