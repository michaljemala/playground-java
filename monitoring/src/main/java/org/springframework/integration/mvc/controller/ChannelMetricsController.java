package org.springframework.integration.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.monitor.MessageChannelMetrics;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChannelMetricsController {
    
    @Autowired
    @Qualifier("twitterChannelMetrics")
    private MessageChannelMetrics twitterChannelMetrics;
    
    @Autowired
    @Qualifier("jmsChannelMetrics")
    private MessageChannelMetrics jmsChannelMetrics;
    
    @RequestMapping(value="/metrics")
    public void home(HttpServletResponse resp) throws IOException {
	resp.setContentType("text/html");
	PrintWriter writer = resp.getWriter();
	writer.write("<html><head><meta http-equiv=\"refresh\" content=\"1\"/></head><body>");
	writer.write("<ul>");
	writer.write("<li>TwitterChannel.getTimeSinceLastSend() = " + String.valueOf(twitterChannelMetrics.getTimeSinceLastSend() + "</li>"));
	writer.write("<li>JmsChannel.getTimeSinceLastSend() = " + String.valueOf(jmsChannelMetrics.getTimeSinceLastSend() + "</li>"));
	writer.write("</ul></body></html>");
	resp.flushBuffer();
    }

}
