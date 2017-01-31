package rober.wildfly.echos.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rober.wildfly.echos.common.IEcho;
import rober.wildfly.echos.jpa.Echo;

@Named("echoer")
@ApplicationScoped
public class ManagedBean implements Serializable, IEcho {

	private static final long serialVersionUID = -2171004254593434311L;
	private IEcho oEchoBean = null;
	private int searchId;
	private List<Echo> oEchos=null;
	
	private Integer id = null;
	private Echo oEcho = null;

	public String getName() {
		return "I am the ECHO bean.";
	}

	private IEcho getEchoBean() {
		if (oEchoBean == null) {
			try {
				InitialContext jndi = new InitialContext();
				oEchoBean = (IEcho) jndi.lookup(IEcho.jndiNAME);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return oEchoBean;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer p_id){
		this.id = p_id;
	}
	public Echo getEcho(){
		return this.oEcho;
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
		this.oEcho = getEchoBean().getEchoById(p_id);
		return this.oEcho;
	}

	@Override
	public List<Echo> getAllEchos() {
		return getEchoBean().getAllEchos();
	}


	@Override
	public List<Echo> searchEchos(String message) {	
		oEchos=getEchoBean().searchEchos(message);
		return oEchos;
	}

	public int getSearchId() {
		return searchId;
	}

	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

	public List<Echo> getoEchos() {
		return oEchos;
	}
}
