package com.nt.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulPreeFilter extends ZuulFilter {

	private Logger logger=LoggerFactory.getLogger(ZuulPreeFilter.class);
	@Override
	public boolean shouldFilter() {
		// Enables the Filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//Get Current Request Context
		RequestContext context= RequestContext.getCurrentContext();
		//get Request Obj from context Obj
		HttpServletRequest req=context.getRequest();
		// log Request Traping Info
		logger.info("===============From ZuulPreeFilter===============");
		logger.info("Current Request Url :: "+req.getRequestURI());
		logger.info("Current Request Path :: "+req.getServletPath());
		logger.info("Current Request Method :: "+req.getMethod());
		logger.info("Current Request Data Content Type :: "+req.getContentType());
		return null;
	}

	@Override
	public String filterType() {
		//Make the filter as pre type filter
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		//High Priority Filter
		return 0;
	}

}
