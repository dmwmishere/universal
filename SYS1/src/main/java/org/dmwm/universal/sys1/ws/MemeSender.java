package org.dmwm.universal.sys1.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.dmwm.universal.core.data.xsds.MemeInfoType;
import org.dmwm.universal.core.data.xsds.Response;

@WebService
public interface MemeSender {
	Response sendMeme(@WebParam(name="memeid") int memeid, @WebParam(name="dankLevel") int dankLevel);
	String addMeme(@WebParam(name="MemeInfo") MemeInfoType mit);
}
