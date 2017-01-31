package rober.wildfly.echos.common;

import java.util.List;

import rober.wildfly.echos.jpa.Echo;

public interface IEcho {

	public int storeEcho(String message);
	public Echo getEchoById(int p_id);
	public List<Echo> getAllEchos();
	
	public int updateEcho(int id,String updateName);
	int updateEcho();
	
	
	
}
