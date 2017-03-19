package org.dmwm.universal.core.utils.database;

import org.dmwm.universal.core.data.xsds.MemeInfoType;
import org.dmwm.universal.core.data.xsds.Response;

public interface QueryProcessor {
	Response getMeme(int id);
	void insertMeme(MemeInfoType mit);
	void startOperation(String uuid, int operId, String data, int state);
	Long stopOperation(String uuid);
}