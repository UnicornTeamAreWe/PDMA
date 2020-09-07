from selenium import webdriver
import time
import pymysql
from bs4 import BeautifulSoup

# 数据库连接
conn = pymysql.connect(user='root', password='LeBronQ20000624', host='localhost', port=3306, database='PDMA')
# 建立游标
c = conn.cursor()

class weibo():
    def Login(self):
        options = webdriver.ChromeOptions()
        # 此步骤很重要，设置为开发者模式，防止被各大网站识别出来使用了Selenium
        options.add_experimental_option('excludeSwitches', ['enable-automation'])
        self.browser = webdriver.Chrome(options=options)

        self.browser.get('https://weibo.com/')
        time.sleep(10)
        self.browser.find_element_by_id('loginname').send_keys('17388121920')
        self.browser.find_element_by_name('password').send_keys('LeBronQ20000624')
        self.browser.find_element_by_class_name('W_btn_a').click()
        while self.browser.current_url == "https://weibo.com/login.php":
            time.sleep(1)


    def getInfo(self):
        import time
        time.sleep(15)
        soup = BeautifulSoup(self.browser.page_source, 'lxml')
        body = soup.find('body')
        div = body.find('div',attrs = {'id':'plc_frame'})
        follow = div.find('strong', attrs={'node-type':'follow'}).get_text()
        fans = div.find('strong', attrs={'node-type':'fans'}).get_text()
        wb = div.find('strong', attrs={'node-type':'weibo'}).get_text()
        self.browser.find_element_by_xpath('//*[@id="v6_pl_rightmod_myinfo"]/div[1]/div/div[2]/ul/li[1]').click()
        time.sleep(10)

        soup = BeautifulSoup(self.browser.page_source, 'lxml')
        body = soup.find('body')
        div = body.find('div',attrs = {'id':'plc_main'})
        self.browser.find_element_by_xpath('//*[@id="Pl_Official_RelationLeftNav__81"]/div[2]/div[1]/div/div/div/div/ul/li[1]/ul/li[5]')
        level2 = div.find_all('li', attrs={'class':'lev2'})
        Weifenzu = level2[3].find('em', attrs={'class':'num'}).get_text()
        quantity = []
        level3 = div.find_all('li', attrs={'class':'lev3'})
        for lev in level3:
            quantity.append(lev.find('em', attrs={'class':'num'}).get_text())
        print(quantity)
        c.execute("INSERT INTO `PDMA`.`Weibo`"
                  "(`user_id`,`Wb`,`Fans`,`Follow`,`Unclassified`,`Cross_talk`,`Movie`,`Sports`,`Beauty`,`Game`,`Digital`,`Photography`,`Emotion`,`Pet`,`Police`,`Cartoon`,`Star`,`Celebrity`,`Colleague`,`Classmate`) "
                  "VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",
                  (1,wb,fans,follow,Weifenzu,quantity[0],quantity[1],quantity[2],quantity[3],quantity[4],quantity[5],quantity[6],quantity[7],quantity[8],quantity[9],quantity[10],quantity[11],quantity[12],quantity[13],quantity[14]))

if __name__ == '__main__':
    # 填入自己的用户名，密码
    wb = weibo()
    wb.Login()
    wb.getInfo()
    conn.commit()
    c.close()
    conn.close()
    print("done")
