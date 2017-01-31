package rober.wildfly.echos.common;

import java.util.List;

import rober.wildfly.echos.jpa.Echo;

public interface IEcho {
	public static final String jndiNAME="java:global/wildfly-echos-ear-0.0.1-SNAPSHOT/wildfly-echos-ejb-0.0.1-SNAPSHOT/EchoBean";

	public int storeEcho(String message);
	public Echo getEchoById(int p_id);
	public List<Echo> getAllEchos();
	public List<Echo> searchEchos(String message);
	public int updateEcho(int id,String updateName);
}
