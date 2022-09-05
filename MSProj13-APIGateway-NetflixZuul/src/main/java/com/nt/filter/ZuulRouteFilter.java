package com.nt.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulRouteFilter extends ZuulFilter {

	Logger logger=LoggerFactory.getLogger(ZuulRouteFilter.class);
	@Override
	public boolean shouldFilter() {
		// 
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//Get RequestContext Obj 
		RequestContext context=RequestContext.getCurrentContext();
		//Write Log Msg
		logger.info("===============From ZuulRaouteFilter===============");
		logger.info("Routing Host Info :: "+context.getRouteHost());
		
		return null;
	}

	@Override
	public String filterType() {
		// 
		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
