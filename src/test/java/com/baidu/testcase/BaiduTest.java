package com.baidu.testcase;

import com.baidu.base.BaseTest;
import com.baidu.common.BasePage;
import com.baidu.common.PageCommon;
import com.baidu.data.BaiduData;
import com.baidu.locator.BaiduLocator;
import com.baidu.util.Assertion;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("百度首页")
@Slf4j
public class BaiduTest extends BaseTest {
    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(BaiduData.baiduurl);
        log.info("进入 百度首页 页面");
    }

    @Story("搜索")
    @Test
    public void ContentListTest() {
        bp.findElement(BaiduLocator.baiduInput).sendKeys(BaiduData.baiduButton);
        bp.findElement(BaiduLocator.baiduButton).click();
        bp.switchNextHandle();
    }

}
