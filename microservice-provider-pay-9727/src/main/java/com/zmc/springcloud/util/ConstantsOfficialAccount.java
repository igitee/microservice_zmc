
package com.zmc.springcloud.util;

import com.zmc.springcloud.service.WechatOfficialAccountService;
import org.springframework.web.context.ContextLoader;

import java.util.List;

/**
 * Created by zhangcong on 2017/11/15.
 */
public class ConstantsOfficialAccount {
	
	private static ConstantsOfficialAccount instance;
	
    /**appid 微信分配的公众账号ID*/
	private String APP_ID;
	/**appid xiaochengxu id*/
	private String XCX_APP_ID;
    /**商户号 微信分配的公众账号ID*/
	private String MCH_ID;
    /**API密钥，在商户平台设置*/
	private String API_KEY;
	
	private void setInfo() throws Exception{
		WechatOfficialAccountService wechatOfficialAccountService = (WechatOfficialAccountService) ContextLoader.getCurrentWebApplicationContext().getBean(WechatOfficialAccountService.class);
    	List<WechatOfficialAccount> list=wechatOfficialAccountService.findList();
    	if(list!=null && !list.isEmpty()){
    		WechatOfficialAccount wechatOfficialAccount=list.get(0);
    		this.APP_ID=wechatOfficialAccount.getAppId();
    		this.MCH_ID=wechatOfficialAccount.getMchId();
    		this.API_KEY=wechatOfficialAccount.getApiKey();
    		this.XCX_APP_ID=wechatOfficialAccount.getXcxAppId();
    	}else{
    		this.APP_ID=null;
    		this.MCH_ID=null;
    		this.API_KEY=null;
    		this.XCX_APP_ID=null;
    	}
	}
    
    
    
    public static ConstantsOfficialAccount getInstance() throws Exception{
    	if(instance==null){
    		instance=new ConstantsOfficialAccount();
        	instance.setInfo();
    	}
    	
    	return instance;
    }

	public String getAPP_ID() {
		return this.APP_ID;
	}

	public String getMCH_ID() {
		return this.MCH_ID;
	}

	public String getAPI_KEY() {
		return this.API_KEY;
	}



	public String getXCX_APP_ID() {
		return XCX_APP_ID;
	}



	public void setXCX_APP_ID(String xCX_APP_ID) {
		XCX_APP_ID = xCX_APP_ID;
	}
}
