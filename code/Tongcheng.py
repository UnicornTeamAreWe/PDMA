from selenium import webdriver
import time
import pymysql
from bs4 import BeautifulSoup
from selenium.webdriver.common.action_chains import ActionChains

# 数据库连接
conn = pymysql.connect(user='root', password='LeBronQ20000624', host='localhost', port=3306, database='PDMA')
# 建立游标
c = conn.cursor()


class tongcheng():

    def __init__(self):
        options = webdriver.ChromeOptions()
        # 此步骤很重要，设置为开发者模式，防止被各大网站识别出来使用了Selenium
        options.add_experimental_option('excludeSwitches', ['enable-automation'])
        self.browser = webdriver.Chrome(options=options)

        # 最大化窗口
        self.browser.maximize_window()
        self.browser.implicitly_wait(5)
        self.domain = 'https://passport.ly.com/?pageurl=http%3a%2f%2fmember.ly.com%2forder'


    def login(self, username, password):
        self.browser.get(self.domain)
        time.sleep(1)

        self.browser.find_element_by_xpath('/html/body/div[2]/div/div[2]/div/div[1]/div[2]').click()
        self.browser.find_element_by_xpath('//*[@id="account_pop"]').send_keys(username)
        self.browser.find_element_by_xpath('//*[@id="actpwd_pop"]').send_keys(password)
        time.sleep(1)
        self.browser.find_element_by_xpath('//*[@id="commonLoginBtn"]').click()

    def getInfo(self):
            import time
            while True:
                if self.browser.current_url != "https://passport.ly.com/?pageurl=http%3a%2f%2fmember.ly.com%2forder":
                    #进入订单界面
                    order = self.browser.find_element_by_xpath('//*[@id="orderList"]/div[2]/div')
                    ActionChains(self.browser).move_to_element(order).perform()
                    time.sleep(5)
                    self.browser.find_element_by_xpath('//*[@id="orderList"]/div[2]/div/ul/li[2]').click()
                    time.sleep(5)
                    while True:
                        #开始获取信息
                        soup = BeautifulSoup(self.browser.page_source, 'lxml')
                        body = soup.find('body')
                        div = body.find('div', attrs={'id': 'content'})
                        #获取当前页面所有订单
                        divs = div.find_all('li', attrs={'class': 'qcp order_li'})
                        for div in divs:
                            #headerInfo
                            spans = div.find('span', attrs = {'class':'list_title'})
                            img = div.find('img')
                            #商品信息
                            time_info = div.find('span', attrs = {'class':'order_detail'}).get_text()
                            ti = time_info.replace('出发时间：','')
                            plat = div.find('span', attrs = {'class':'order_plat'}).get_text()
                            title = spans.find('span').get_text()
                            #金额
                            price = div.find('span', attrs = {'class':'list_money'}).get_text()
                            pr = price.replace('¥','')
                            #订单号
                            order_num = div.find('span', attrs = {'class':'order_number'}).get_text()
                            #状态
                            state = div.find('span', attrs = {'class':'list_state'}).get_text()
                            c.execute("INSERT INTO `PDMA`.`Tongcheng` (`user_id`,`Time`,`Platform`,`Title`,`Price`,`Order_num`,`State`)"
                                      "VALUES(%s,%s,%s,%s,%s,%s,%s)",
                                      (1,ti,plat,title,pr,order_num,state))
                            conn.commit()
                            print(ti,plat,title,pr,order_num,state)
                        break
                    break
                else:
                    continue

    def get_user(self):
            sql = "select username, password from software where user_id = 1"
            c.execute(sql)
            data = c.fetchall()
            return data


if __name__ == '__main__':
    # 填入自己的用户名，密码
    tc = tongcheng()
    # data = tb.get_user()
    # username = data[0][0]
    # password = data[0][1]
    username = '17388121920'
    password = 'LeBronQ20000624'

    tc.login(username, password)
    tc.getInfo()
    print("done")
    c.close()
    conn.close()
