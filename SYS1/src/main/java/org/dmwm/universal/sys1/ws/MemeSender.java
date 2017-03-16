package org.dmwm.universal.sys1.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.dmwm.universal.core.data.xsds.Memedesc;

@WebService
public interface MemeSender {
	Memedesc sendMeme(@WebParam(name="memeid") int memeid, @WebParam(name="dankLevel") int dankLevel);

}
