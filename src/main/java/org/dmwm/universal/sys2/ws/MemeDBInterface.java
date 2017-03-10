package org.dmwm.universal.sys2.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.dmwm.universal.sys1.data.xsds.MemeInfoType;

@WebService
public interface MemeDBInterface {
	String insertMeme(@WebParam(name="MemeInfo") MemeInfoType mit);
}
