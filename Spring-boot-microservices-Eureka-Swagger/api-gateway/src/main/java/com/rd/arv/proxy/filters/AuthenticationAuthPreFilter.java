package com.rd.arv.proxy.filters;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.rd.arv.proxy.util.FilterUtils;
import com.rd.arv.zuul.model.UserInfo;

public class AuthenticationAuthPreFilter extends ZuulFilter {
	private static final String HTTP_USER_URL = "http://localhost:8090/user";
	private static final int FILTER_ORDER = 1;
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationAuthPreFilter.class);
	
	@Autowired
    RestTemplate restTemplate;
	
	@Override
	public boolean shouldFilter() {
		LOGGER.info("++++++++++++++++++++++++test1::" + RequestContext.getCurrentContext().getRequest().getRemoteHost());
		return !RequestContext.getCurrentContext().getRequest().getRequestURI().equals("/authorization/oauth/token");
	}	

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		LOGGER.info("++++++++++++++++++++++++test2::" + ctx.getRequest().getRemoteHost());
		
		if(!isAuthTokenExist()) {
			RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			RequestContext.getCurrentContext().setSendZuulResponse(false);
			return null;
		}
		
		UserInfo userInfo = isAuthTokenValid();
		if(!isAuthTokenPresent() || userInfo == null) {
			ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			ctx.setSendZuulResponse(false);
		}
		
		FilterUtils.setUserId(userInfo.getUserId());
		FilterUtils.setOrgId(userInfo.getOrganizationId());
		
		return null;
	}

	private boolean isAuthTokenPresent() {
		return FilterUtils.getAuthToken() == null;
	}

	private UserInfo isAuthTokenValid() {
		ResponseEntity<UserInfo> restExchange = null;
		try {
			//restExchange = restTemplate.exchange(HTTP_USER_URL, HttpMethod.GET, null, UserInfo.class, FilterUtils.getAuthToken());
			HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth(FilterUtils.getAuthToken());
			restExchange = restTemplate.exchange(RequestEntity.get(new URI(HTTP_USER_URL)).headers(headers).build(), UserInfo.class);
		} catch (HttpClientErrorException e) {
			if(e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				return null;
			}
			throw e;
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return restExchange.getBody();
	}

	private boolean isAuthTokenExist() {
		if(isAuthTokenPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public String filterType() {
		return FilterUtils.PRE_FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}

}
