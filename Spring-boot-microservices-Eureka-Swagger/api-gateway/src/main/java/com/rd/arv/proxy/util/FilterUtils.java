package com.rd.arv.proxy.util;

import com.netflix.zuul.context.RequestContext;

public class FilterUtils {
	public static final String PRE_FILTER_TYPE = "pre";
	public static final String AUTH_TOKEN = "Authorization";
	public static final String USER_ID = "tmx-user-id";
	public static final String ORG_ID = "tmx-org-id";
	
	public static final String getUserId(){
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getRequest().getHeader(USER_ID) !=null) {
            return ctx.getRequest().getHeader(USER_ID);
        }
        else{
            return  ctx.getZuulRequestHeaders().get(USER_ID);
        }
    }

    public static void setUserId(String userId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(USER_ID,  userId);
    }
    
    public static void setOrgId(String orgId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(ORG_ID,  orgId);
    }

    public static final String getAuthToken(){
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getHeader(AUTH_TOKEN);
    }
}
