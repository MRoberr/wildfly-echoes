package rober.wildfly.echos.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rober.wildfly.echos.common.IEcho;

public class Main {

	private IEcho oEchoBean = null;

	public Main() {
		
	}

	public int storeEcho(String message) throws NamingException {

		try {

			final Hashtable<String, String> jndiProperties = new Hashtable<>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

			final Context context = new InitialContext(jndiProperties);

			oEchoBean = (IEcho) context.lookup(IEcho.jndiName + "!" + IEcho.class.getName());

			oEchoBean.storeEcho(message);
			oEchoBean = null;

			System.out.println("sd");
		} catch (NamingException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {

		Main oMain = new Main();
		try {
			oMain.storeEcho("malacka");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		oMain = null;

	}
}
