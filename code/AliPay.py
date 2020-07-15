from selenium import webdriver
from selenium.webdriver.support.select import Select

def Download():
     browser.find_element_by_xpath('//*[@id="main"]/div[2]/div/div[2]/div/div/a[1]').click()

def SelectTime(time):
    js = "document.getElementById('J-select-range').style.display='block';"
    browser.execute_script(js)
    browser.find_element_by_xpath('//*[@id="J-datetime-select"]/a[1]').click()
    if time == "最近一周":
        Select(browser.find_element_by_name("dateRange")).select_by_value("sevenDays")
    elif time == "最近一个月":
        Select(browser.find_element_by_name("dateRange")).select_by_value("oneMonth")
    elif time == "最近三个月":
        Select(browser.find_element_by_name("dateRange")).select_by_value("threeMonths")

def Submit():
    browser.find_element_by_xpath('//*[@id="J-set-query-form"]').click()

if __name__ == "__main__":
    browser = webdriver.Chrome()
    browser.get("https://auth.alipay.com/login/index.htm?goto=https%3A%2F%2Fconsumeprod.alipay.com%2Frecord%2Fadvanced.htm")

    while True:
        if browser.current_url == "https://consumeprod.alipay.com/record/advanced.htm":
            SelectTime("最近一个月")
            Submit()
            Download()
            break
        else:
            continue





