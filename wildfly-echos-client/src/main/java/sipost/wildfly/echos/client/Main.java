package sipost.wildfly.echos.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rober.wildfly.echos.common.IEcho;


//Jar with dependencies futtatasa
public class Main {
	private IEcho oIEcho = null;

	public Main() {
	}

	public int store(String p_message) {
		try {
			oIEcho = lookupIEcho();
			return oIEcho.storeEcho(p_message);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static void main(String[] args) {
		Main oMain = new Main();
		oMain.store("malacka");
		oMain = null;
	}

	private static IEcho lookupIEcho() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		// let's do the lookup
		return (IEcho) context.lookup(IEcho.jndiNAME+"!"+ IEcho.class.getName());
	}
}
