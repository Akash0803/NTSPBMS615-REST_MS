package com.nt.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulErrorFilter extends ZuulFilter {

	Logger logger=LoggerFactory.getLogger(ZuulErrorFilter.class);
	@Override
	public boolean shouldFilter() {
		//Enable Filter
		return true	;
	}

	@Override
	public Object run() throws ZuulException {
		// Get RequestContext Obj
		RequestContext context=RequestContext.getCurrentContext();
		//Get Throwable Obj
		Throwable throwable=context.getThrowable();
		//Write Log Msg
		logger.info("Exception Msg :: "+throwable.getMessage());
		logger.info("Exception Type :: "+throwable);
		
		return null;
	}

	@Override
	public String filterType() {
		// Error Filter
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
