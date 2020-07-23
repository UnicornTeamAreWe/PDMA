import csv
import mysql.connector

#数据库连接
conn = mysql.connector.connect(user='root', password='LeBronQ20000624', host='localhost', port='3306', database='PDMA',
                               use_unicode=True)
conn.autocommit = True
#建立游标
c = conn.cursor()

#打开文件
csv_file = csv.reader(open('alipay_record_20200722_0855_1.csv','r',encoding="GB2312"))
next(csv_file, None)
data=[]
for row in csv_file:
    data.append(row)

for i in range (4,len(data)):
    list=[]
    for row in data[i]:
         list.append(row)
    # print(list[0])
    # print(list[1])
    # print(list[2])
    # print(list[3])
    # print(list[4])
    # print(list[5])
    # print(list[6])
    # print(list[7])
    # print(list[8])
    # print(list[9])
    # print(list[10])
    # print(list[11])
    # print(list[12])
    # print(list[13])
    # print(list[14])
    # print(list[15])
    # print(list[16])
    c.execute("INSERT INTO `PDMA`.`Alipay`(`user_id`,`Transaction_number`,`Payment_time`,`Commodity_name`,`Amount`,`Funding_state`,`Name`,`Income_spending`) VALUES(%s,%s,%s,%s,%s,%s,%s,%s)",
                                      (1,list[0],list[2],list[7],list[9],list[8],list[11],list[10]))


