import pandas as pd
from IPython.display import display
from sqlalchemy import create_engine
import matplotlib.pyplot as plt
import numpy as np


#用户名:密码@localhost
engine = create_engine('mysql+pymysql://root:root@localhost:3306/pdma')


sql_query = 'select * from taobao;'
taobao_df = pd.read_sql_query(sql_query,engine)

taobao_df['Transaction_time'] = pd.DatetimeIndex(taobao_df['Transaction_time'])
# df = pd.DataFrame(taobao_df,columns = ['time','prize'])
# df.set_index('time',inplace= True)
# print(df.index)
taobao_df['month'] = taobao_df['Transaction_time'].month



#1.用户月消费趋势分析
#1.1 每月消费总金额
taobao_df['order'] = 1
print(taobao_df.head())
print(taobao_df.describe())
taobao_df.info()

#按月分组
group_month = taobao_df.groupby('month')

#月消费总金额 = 按月分组.消费金额.sum()
order_month_amount = group_month['Price'].sum()
print(order_month_amount.head())
order_month_amount.plot()

#1.2每月消费次数
#月订单数
group_month['order'].sum().plot()

#1.3每月消费人数

#1.4每月用户平均消费金额

#1.5每月用户平均消费次数

#2.单个用户消费趋势分析
#2.1用户消费金额、消费次数的描述统计
#2.2用户消费金额和消费次数的散点图
#2.3用户消费金额的分布图
# taobao_df = pd.to_datetime(pd.Series(taobao_df['Transaction_time']), format='%Y/%m/%d')
# taobao_df.index = taobao_df.dt.to_period('m')
# taobao_df = taobao_df.groupby(level=0).size()
#
# taobao_df = taobao_df.reindex(pd.period_range(taobao_df.index.min(), taobao_df.index.max(), freq='m'), fill_value=0)























