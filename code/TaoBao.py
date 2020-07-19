from selenium import webdriver
from bs4 import BeautifulSoup
import logging
import time
from selenium.common.exceptions import NoSuchElementException, WebDriverException
from retrying import retry
from selenium.webdriver import ActionChains

logging.basicConfig(level = logging.INFO,format = '%(asctime)s - %(name)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

class taobao():

    def __init__(self):
        options = webdriver.ChromeOptions()
        # 此步骤很重要，设置为开发者模式，防止被各大网站识别出来使用了Selenium
        options.add_experimental_option('excludeSwitches', ['enable-automation'])
        self.browser = webdriver.Chrome(options=options)

        # 最大化窗口
        self.browser.maximize_window()
        self.browser.implicitly_wait(5)
        self.domain = 'http://www.taobao.com'
        self.action_chains = ActionChains(self.browser)


    def login(self, username, password):
        self.browser.get(self.domain)
        time.sleep(1)

        self.browser.find_element_by_xpath('//*[@id="J_SiteNavLogin"]/div[1]/div[1]/a[1]').click()
        self.browser.find_element_by_xpath('//*[@id="fm-login-id"]').send_keys(username)
        self.browser.find_element_by_xpath('//*[@id="fm-login-password"]').send_keys(password)
        time.sleep(1)

        try:
            # 出现验证码，滑动验证
            slider = self.browser.find_element_by_xpath("//span[contains(@class, 'btn_slide')]")
            if slider.is_displayed():
                # 拖拽滑块
                self.action_chains.drag_and_drop_by_offset(slider, 258, 0).perform()
                time.sleep(0.5)
                # 释放滑块，相当于点击拖拽之后的释放鼠标
                self.action_chains.release().perform()
        except (NoSuchElementException, WebDriverException):
            logger.info('未出现登录验证码')
        self.browser.find_element_by_xpath('//*[@id="login-form"]/div[4]/button').click()

    def getInfo(self):
            import time
            while True:
                if self.browser.current_url == "https://www.taobao.com/":
                    self.browser.find_element_by_xpath('//*[@id="J_SiteNavMytaobao"]/div[1]').click()
                    #进入订单界面
                    self.browser.find_element_by_xpath('//*[@id="J_MtSideMenu"]/div/dl/dd[2]').click()
                    time.sleep(1)
                    nextPage_xpath = '//*[@id="tp-bought-root"]/div[3]/div[2]/div/button[2]'
                    while True:
                        time.sleep(1)
                        #开始获取信息
                        soup = BeautifulSoup(self.browser.page_source, 'lxml')
                        body = soup.find('body')
                        div = body.find('div', attrs={'id': 'page'})
                        #获取当前页面所有订单
                        divs = div.find_all('div', attrs={'class': 'index-mod__order-container___1ur4- js-order-container'})
                        for div in divs:
                            #headerInfo
                            header = div.find('tbody', attrs = {'class':'bought-wrapper-mod__head___2vnqo'})
                            time_info = header.find('span', attrs = {'class':'bought-wrapper-mod__create-time___yNWVS'}).get_text()
                            store_info = header.find('a', attrs = {'class':'seller-mod__name___2d3js'})
                            if store_info is None:
                                store = ""
                            else:
                                store = store_info.get_text()
                            #商品信息
                            name_div = div.find('div', attrs={'class': 'ml-mod__container___2DOxT production-mod__production___1O-24 suborder-mod__production___3WebF'})
                            name_p = name_div.find('p')
                            name = name_p.find('a').get_text()
                            info_spans = div.find_all('span', attrs={'class': 'production-mod__sku-item___1VEL1'})
                            info = ""
                            for span in info_spans:
                                info = info + span.get_text()
                            #价格
                            price_div = div.find_all('div', attrs={'class': 'price-mod__price___cYafX'})
                            price_p = price_div[1].find('p')
                            price = price_p.get_text()
                            #交易状态
                            state_div = div.find_all('span', attrs={'class':'text-mod__link___1rXmw'})
                            state=""
                            for s_div in state_div:
                                state = state+" "+s_div.get_text()
                            print(time_info + " " + store + " " + name + " " + info + " " + price + " " + state)
                        nextPage = self.browser.find_element_by_xpath(nextPage_xpath)
                        able_to_click = nextPage.is_enabled()
                        if able_to_click==False:
                            break
                        else:
                            nextPage.click()

                    break
                else:
                    continue

if __name__ == '__main__':
    # 填入自己的用户名，密码
    username = ''
    password = ''
    tb = taobao()
    tb.login(username, password)
    tb.getInfo()
    print("done")

