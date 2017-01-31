package rober.wildfly.echoes.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rober.wildfly.echoes.common.IEcho;
import rober.wildfly.echoes.jpa.Echo;

@Named("echoer")
@ApplicationScoped
public class ManagedBean implements Serializable, IEcho {

	private static final long serialVersionUID = -2171004254593434311L;
	private IEcho oEchoBean = null;

	public String getName() {
		return "I am the ECHO bean.";
	}

	private IEcho getEchoBean() {
		if (oEchoBean == null) {
			try {
				InitialContext jndi = new InitialContext();
				oEchoBean = (IEcho) jndi.lookup("java:global/wildfly-echos-ear-0.0.1-SNAPSHOT/wildfly-echos-ejb-0.0.1-SNAPSHOT/EchoBean");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return oEchoBean;
	}
	
	public int getStore() {
		return storeEcho("Halihó őŐűŰ");
	}

	@Override
	public int storeEcho(String p_message) {
		return getEchoBean().storeEcho(p_message);
	}

	@Override
	public Echo getEchoById(int p_id) {
		return getEchoBean().getEchoById(p_id);
	}

	@Override
	public List<Echo> getAllEchos() {
		return getEchoBean().getAllEchos();
	}

}
