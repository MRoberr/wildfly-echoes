package rober.wildfly.echoes.common;

import java.util.List;

import rober.wildfly.echoes.jpa.Echo;

public interface IEcho {
	public static final String jndiName = "java:global/wildfly-echos-ear-0.0.1-SNAPSHOT/wildfly-echos-ejb-0.0.1-SNAPSHOT/EchoBean";
	

	public int storeEcho(String message);
	public Echo getEchoById(int p_id);
	public List<Echo> getAllEchos();
}
