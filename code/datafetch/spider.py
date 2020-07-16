# encoding:utf-8

from selenium import webdriver
from bs4 import BeautifulSoup
import pickle
import time
import sys
import os
import io

browser = webdriver.Chrome("D:/Google/Chrome/Application/chromedriver.exe")


def login():
    try:
        print(u'开始登陆...')

        login_url = 'https://passport.meituan.com/account/unitivelogin?service=www&continue=https%3A%2F%2Fwww.meituan.com%2Faccount%2Fsettoken%3Fcontinue%3Dhttp%253A%252F%252Fwww.meituan.com%252Forders%252F#status=0'
        url = 'https://www.meituan.com/orders/#status=0'
        home_url = 'https://www.meituan.com/'
        browser.get(login_url)
        while True:
            print('please login')
            print(browser.current_url)
            time.sleep(5)
            if browser.current_url == home_url:
                browser.get(url)
                return
    except:
        print('error')
    finally:
        print('done')


def getInfo():
    try:
        url_arr=[]
        time.sleep(1)
        soup = BeautifulSoup(browser.page_source, 'lxml')
        body = soup.find('body')
        divs = body.find_all('div',attrs={'class':'info-box'})
        for div in divs:
            t = div.find_all('p')
            print(t[2].get_text())
            hf = div.find_all('a',href=True)
            url_arr.append(hf[0]['href'])
        for u in url_arr:
            getLoc(u)
        browser.close()
    except:
        print('error')
    finally:
        print('done')

def getLoc(href):
    try:
        browser.get(href)
        time.sleep(1)
        bs = BeautifulSoup(browser.page_source,'lxml')
        bd = bs.find('body')
        info = bd.find_all('div',attrs={'class':'base-info'})
        divs = info[0].find_all('div')
        loc = divs[1].get_text()
        print(loc)
    except:
        print('loc_error')
    finally:
        print('done')

if __name__ == '__main__':
    login()
    getInfo()
    sys.exit()
