package com.nt.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulPostFilter extends ZuulFilter {

	private Logger logger=LoggerFactory.getLogger(ZuulPostFilter.class); 
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// get RequestContext obj
		RequestContext context=RequestContext.getCurrentContext();
		//Get Rwsponse Obj
		HttpServletResponse res=context.getResponse();
		//Log response Traping Info
		logger.info("===============From ZuulPostFilter===============");
		logger.info("Response Content Type :: "+res.getContentType());
		logger.info("Response Status :: "+res.getStatus());
		logger.info("Response Host Name :: "+res.getHeader("host"));
		logger.info("Response Server Name :: "+res.getHeader("server"));
		return null;
	}

	@Override
	public String filterType() {
		// PostFilter
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
