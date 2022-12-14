import time
from appium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from appium.webdriver.common.appiumby import AppiumBy

caps = {}
# Android平台测试
caps['platformName'] = 'Android'
# 测试手机版本为5.0
caps['platformVersion'] = '10'
caps['deviceName'] = 'Infinix_X683'
# 系统手机中的联系人app的包名
caps['appPackage'] = 'com.example.androidtest'
# 系统手机中的联系人app的主入口activity
caps['appActivity'] = 'com.example.androidtest.MainActivity'
caps["noReset"] = True
caps["ensureWebviewsHavePages"] = True
caps["nativeWebScreenshot"] = True
caps["newCommandTimeout"] = 3600 # 秒单位,超时自动退出
caps["connectHardwareKeyboard"] = True

# 连接测试机所在服务器服务器
driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', caps)


element = WebDriverWait(driver, 5).until(lambda x: x.find_element(by=AppiumBy.ID, value=caps["appPackage"] + ":id/btn_skip"))
element.click()
 

time.sleep(10)
#断开连接
driver.quit()
 