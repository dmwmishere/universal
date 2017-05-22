package org.dmwm.universal.sys0.ws;

import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface Boeing767 {
	String sendMeme(@WebParam(name="Date") String dankdate);
}
