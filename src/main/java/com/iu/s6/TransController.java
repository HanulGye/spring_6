package com.iu.s6;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanul.trans.Transport;
import com.hanul.trans.Trip;

@Controller
@RequestMapping(value="/trans/**")
public class TransController {

	@Inject
	private Transport transport;
	@Inject
	private Trip trip;

	@RequestMapping(value="/trip")
	public void go() {
		trip.go();
	}
	
	
	@RequestMapping(value="/go")
	public void start() {
		transport.bus();
	}
	
	
	
	
	
}
