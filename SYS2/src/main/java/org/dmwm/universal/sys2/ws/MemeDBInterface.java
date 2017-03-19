package org.dmwm.universal.sys2.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.dmwm.universal.core.data.xsds.MemeInfoType;

@WebService
public interface MemeDBInterface {
	String insertMeme(@WebParam(name="MemeInfo") MemeInfoType mit);
}
